package com.LinguaNova.IdiomaGo.util.mapper.impl.category;

import com.LinguaNova.IdiomaGo.persistence.entity.CategoryEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.category.CategoryDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.category.CreateCategotyDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.category.ICategoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper implements ICategoryMapper {

    @Override
    public CategoryDTO mapTo(CategoryEntity category) {
        return INSTANCE.mapTo(category);
    }

    @Override
    public List<CategoryDTO> mapToList(List<CategoryEntity> categories) {
        return INSTANCE.mapToList(categories);
    }

    @Override
    public CategoryEntity mapFrom(CreateCategotyDTO categoryDTO) {
        return INSTANCE.mapFrom(categoryDTO);
    }
}
