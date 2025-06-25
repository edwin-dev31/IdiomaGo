package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.presentation.dto.favorite.CreateFavoriteDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.favorite.FavoriteDTO;
import java.util.List;

public interface IFavoriteService {
	FavoriteDTO save(CreateFavoriteDTO dto);
	void delete(Long userId, Long wordTranslationId);
	List<FavoriteDTO> getAll();
}
