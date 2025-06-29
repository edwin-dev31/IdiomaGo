package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.*;
import com.LinguaNova.IdiomaGo.persistence.repository.ICategoryRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.ILanguageRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.CreateWordTranslationDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.WordTranslationDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordTranslationService;
import com.LinguaNova.IdiomaGo.util.Visibility;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import com.LinguaNova.IdiomaGo.util.mapper.impl.wordTranslation.CreateWordTranslationMapper;
import com.LinguaNova.IdiomaGo.util.mapper.impl.wordTranslation.WordTranslationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordTranslationService implements IWordTranslationService {

	private final IWordTransalationRepository repository;
	private final IWordRepository wordRepository;
	private final ILanguageRepository languageRepository;
	private final ICategoryRepository categoryRepository;
	private final WordTranslationMapper mapper;
	private final CreateWordTranslationMapper createMapper;

	public WordTranslationService(IWordTransalationRepository repository,
                                  IWordRepository wordRepository, ILanguageRepository languageRepository, ICategoryRepository categoryRepository, WordTranslationMapper mapper,
                                  CreateWordTranslationMapper createMapper) {
		this.repository = repository;
		this.wordRepository = wordRepository;
		this.languageRepository = languageRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
		this.createMapper = createMapper;
	}

	@Override
	public List<WordTranslationDTO> getAll() {
		List<WordTranslationEntity> entities = repository.findAll().stream()
				.filter(e -> e.getVisibility() == Visibility.PUBLIC)
				.toList();
		return mapper.mapToList(entities);
	}

	@Override
	public Optional<WordTranslationDTO> getById(Long id) {
		Optional<WordTranslationEntity> result = repository.findById(id);
		return result.map(mapper::mapTo);
	}

	@Override
	public WordTranslationDTO save(CreateWordTranslationDTO wordTranslationDTO) {
		WordEntity word = wordRepository.findById(wordTranslationDTO.getWordId())
			.orElseThrow(() -> new ResourceNotFoundException("Word not found with ID: " +
					wordTranslationDTO.getWordId()));

		LanguageEntity language = languageRepository.findById(wordTranslationDTO.getLanguageId())
			.orElseThrow(() -> new ResourceNotFoundException("Language not found with ID: " +
					wordTranslationDTO.getLanguageId()));

		WordTranslationEntity entity = createMapper.mapFrom(wordTranslationDTO, word, language);

		WordTranslationEntity saved = repository.save(entity);
		return mapper.mapTo(saved);
	}

	public WordTranslationEntity saveTranslationFull(
				UserEntity user, String originalWord, String translatedWord,
		 		String example, String description, String languageCode, Long categoryId,
				String imageUrl, Visibility visibility) {

		WordEntity word = findOrCreateWord(originalWord);
		LanguageEntity language = getLanguageOrThrow(languageCode);
		CategoryEntity category = getCategoryOrThrow(categoryId);

		checkIfTranslationExists(word.getId(), language.getId());

		WordTranslationEntity entity = new WordTranslationEntity();
		entity.setUser(user);
		entity.setWord(word);
		entity.setLanguage(language);
		entity.setCategory(category);
		entity.setTranslatedWord(translatedWord);
		entity.setTranslatedExample(example);
		entity.setTranslatedDescription(description);
		entity.setImageUrl(imageUrl);
		entity.setVisibility(visibility);

		return repository.save(entity);
	}

	@Override
	public WordTranslationDTO update(Long id, CreateWordTranslationDTO word) {
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<WordTranslationDTO> getByLangId(Long langId) {
		List<WordTranslationEntity> list = repository.findBylanguageId(langId);
		return mapper.mapToList(list);
	}

	private WordEntity findOrCreateWord(String word) {
		return wordRepository.findByNameIgnoreCase(word)
				.orElseGet(() -> {
					WordEntity newWord = new WordEntity();
					newWord.setName(word);
					return wordRepository.save(newWord);
				});
	}

	private LanguageEntity getLanguageOrThrow(String code) {
		LanguageEntity lang = languageRepository.findByCode(code);
		if (lang == null) {
			throw new ResourceNotFoundException("Language not found: " + code);
		}
		return lang;
	}

	private CategoryEntity getCategoryOrThrow(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));
	}

	private void checkIfTranslationExists(Long wordId, Long languageId) {
		if (repository.existsByWordIdAndLanguageId(wordId, languageId)) {
			throw new IllegalStateException("Translation already exists for this word and language.");
		}
	}

	public List<WordTranslationDTO> findByUserAndVisibility(Long userId, Visibility visibility) {
		List<WordTranslationEntity> list = repository.findByUserIdAndVisibility(userId, visibility);
		return mapper.mapToList(list);
	}

}
