package com.kondratyev.springmvcrest.services;

import com.kondratyev.springmvcrest.api.v1.mapper.CategoryMapper;
import com.kondratyev.springmvcrest.api.v1.mapper.CategoryMapperImpl;
import com.kondratyev.springmvcrest.api.v1.model.CategoryDTO;
import com.kondratyev.springmvcrest.domain.Category;
import com.kondratyev.springmvcrest.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";

    CategoryMapper categoryMapper = new CategoryMapperImpl();
    CategoryRepository categoryRepository = mock(CategoryRepository.class);
    CategoryService categoryService = new CategoryServiceImpl(categoryMapper, categoryRepository);

    @Test
    void getAllCategories() {

        //given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        //when
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        //then
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    void getCategoryByName() {

        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        //then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }

}