package com.kondratyev.springmvcrest.api.v1.mapper;

import com.kondratyev.springmvcrest.api.v1.model.CategoryDTO;
import com.kondratyev.springmvcrest.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToCategoryDTO (Category category);

}
