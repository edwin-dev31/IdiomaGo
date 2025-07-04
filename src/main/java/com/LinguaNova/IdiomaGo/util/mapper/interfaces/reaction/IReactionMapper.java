package com.LinguaNova.IdiomaGo.util.mapper.interfaces.reaction;

import com.LinguaNova.IdiomaGo.persistence.entity.ReactionEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.reaction.CreateReactionDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.reaction.ReactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IReactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "wordTranslation", source = "wordTranslation")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    ReactionEntity mapFrom(CreateReactionDTO dto, UserEntity user, WordTranslationEntity wordTranslation);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "wordTranslationId", source = "wordTranslation.id")
    ReactionDTO mapTo(ReactionEntity entity);
}
