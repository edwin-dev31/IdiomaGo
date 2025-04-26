package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.FavoriteEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.FavoriteId;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IFavoriteRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.favorite.CreateFavoriteDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.favorite.FavoriteDTO;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.favorite.IFavoriteMapper;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FavoriteService {

	private final IFavoriteRepository repository;
	private final IUserRepository userRepository;
	private final IWordTransalationRepository wordTranslationRepository;
	private final IFavoriteMapper mapper;

	public FavoriteService(IFavoriteRepository repository, IUserRepository userRepository,
		IWordTransalationRepository wordTranslationRepository, IFavoriteMapper mapper) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.wordTranslationRepository = wordTranslationRepository;
		this.mapper = mapper;
	}

	public FavoriteDTO save(CreateFavoriteDTO dto) {
		UserEntity user = userRepository.findById(dto.getUserId())
			.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		WordTranslationEntity wordTranslation = wordTranslationRepository.findById(dto.getWordTranslationId())
			.orElseThrow(() -> new ResourceNotFoundException("Word translation not found"));

		FavoriteEntity entity = mapper.mapFrom(dto, user, wordTranslation);
		FavoriteId favoriteId = new FavoriteId(dto.getUserId(), dto.getWordTranslationId());
		entity.setId(favoriteId);

		return mapper.mapTo(repository.save(entity));
	}

	public void delete(Long userId, Long wordTranslationId) {
		FavoriteId id = new FavoriteId(userId, wordTranslationId);
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found");
		}
		repository.deleteById(id);
	}

	public List<FavoriteDTO> getAll() {
		return repository.findAll().stream().map(mapper::mapTo).toList();
	}
}
