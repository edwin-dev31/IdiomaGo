package com.LinguaNova.IdiomaGo.util.mapper.interfaces.favorite;

import com.LinguaNova.IdiomaGo.persistence.entity.FavoriteEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.favorite.CreateFavoriteDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.favorite.FavoriteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IFavoriteMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "user", source = "user")
	@Mapping(target = "wordTranslation", source = "wordTranslation")
	@Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
	FavoriteEntity mapFrom(CreateFavoriteDTO dto, UserEntity user, WordTranslationEntity wordTranslation);

	@Mapping(target = "userId", source = "user.id")
	@Mapping(target = "wordTranslationId", source = "wordTranslation.id")
	FavoriteDTO mapTo(FavoriteEntity entity);
}
