package com.hxd.busi.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hxd.bean.common.UserDemo;
import com.hxd.busi.dao.IUserDemoMapperDAO;

import java.util.List;

/**
 * Created by Hu on 2017/7/7.
 */
@Service
public class UserDemoService {

	@Resource
	IUserDemoMapperDAO userDao;
	
	public List<UserDemo> getUserByName(String name) {
		List<UserDemo> users = userDao.getUser(name);
		return users;
	}

	public int insertUser(UserDemo user){
		int id = userDao.insertUser(user);
		if (id == 1){
			return user.getId();
		}
		return 0;
	}

}
