package com.sunbeam.dao;

import com.sunbeam.entities.Tag;

public interface TagDao {
	String addTag(Tag newTag);
	String linkRestaurant(Long tagId, Long restaurantId);
}
