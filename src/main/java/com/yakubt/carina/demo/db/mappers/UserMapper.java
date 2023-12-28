package com.yakubt.carina.demo.db.mappers;

import com.yakubt.carina.demo.db.models.User;

public interface UserMapper {

	void create(User user);

	User findById(int id);

	User findByUserName(String username);

	void update(User user);

	void delete(User user);
}
