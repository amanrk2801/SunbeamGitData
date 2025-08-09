package com.sunbeam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Category;

import jakarta.persistence.EntityManager;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	//depcy
	@Autowired
	private EntityManager manager;

	@Override
	public List<Category> getAllCategories() {
		String jpql="select c from Category c where c.status=true";
		return manager.createQuery(jpql, Category.class)
				.getResultList();
	}

}
