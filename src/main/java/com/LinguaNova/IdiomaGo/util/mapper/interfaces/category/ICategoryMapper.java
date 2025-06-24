package com.LinguaNova.IdiomaGo.util.mapper.interfaces.category;


import com.LinguaNova.IdiomaGo.persistence.entity.CategoryEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.category.CategoryDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.category.CreateCategotyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    CategoryDTO mapTo(CategoryEntity category);
    List<CategoryDTO> mapToList(List<CategoryEntity> categories);
    CategoryEntity mapFrom(CreateCategotyDTO categoryDTO);
}
