package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.User;

public interface UserDAO {
	public User findById(Integer id);
	public List<User> findByName(Object name);
	public boolean deleteById(String className,Integer id);
}
