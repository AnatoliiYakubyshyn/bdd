package com.yakubt.carina.demo.db.mappers;

import com.yakubt.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
