package com.springmvc.applicationImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.application.*;
import com.springmvc.dao.*;
import com.springmvc.entity.*;
@Service("iLoginApp")
@Transactional
public class LoginAppImpl implements ILoginApp {
	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}
	@Autowired(required=true)
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public boolean login(String name,String pwd){
		boolean isRight;
		if(userDao.findByName(name).size() != 0){
			User user = userDao.findByName(name).get(0);
			isRight = user.getpwd().equals(pwd)?true:false;
		}
		else
			isRight = false;
		return isRight;
		
	}
}
