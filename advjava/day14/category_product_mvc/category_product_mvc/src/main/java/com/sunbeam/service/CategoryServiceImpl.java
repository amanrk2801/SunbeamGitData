package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findByStatusTrue();
	}

	@Override
	public Category getCompleteDetails(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.fetchCompleteDetails(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id!!!!!"));
	}

}
