package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.ReactionEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.ReactionRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.reaction.CreateReactionDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.reaction.ReactionDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.reaction.IReactionMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReactionService {

    private final ReactionRepository reactionRepository;
    private final IUserRepository userRepository;
    private final IWordTransalationRepository wordTranslationRepository;
    private final IReactionMapper mapper;

    public ReactionDTO create(CreateReactionDTO dto) {
        var user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        var word = wordTranslationRepository.findById(dto.getWordTranslationId())
                .orElseThrow(() -> new EntityNotFoundException("Word not found"));

        var entity = mapper.mapFrom(dto, user, word);
        return mapper.mapTo(reactionRepository.save(entity));
    }

    public List<ReactionDTO> getAll() {
        return reactionRepository.findAll()
                .stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public List<ReactionDTO> getByWordTranslationId(Long wordTranslationId) {
        return reactionRepository.findByWordTranslationId(wordTranslationId)
                .stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public boolean delete(Long id) {
        if (reactionRepository.existsById(id)) {
            reactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
