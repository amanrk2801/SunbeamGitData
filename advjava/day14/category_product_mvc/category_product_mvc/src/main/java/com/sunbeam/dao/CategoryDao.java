package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {
	List<Category> findByStatusTrue();

	@Query("select c from Category c left join fetch c.products where c.id=:id")
	Optional<Category> fetchCompleteDetails(Long id);
}
