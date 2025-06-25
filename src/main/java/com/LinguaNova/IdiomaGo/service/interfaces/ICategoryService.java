package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.presentation.dto.category.CategoryDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.category.CreateCategotyDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO getById(Long categoryId);
    CategoryDTO save(CreateCategotyDTO dto);
    void delete(Long categoryId);

}
