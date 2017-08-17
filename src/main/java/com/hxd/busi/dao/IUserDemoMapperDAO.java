package com.hxd.busi.dao;

import com.hxd.bean.common.UserDemo;

import java.util.List;

/**
 * Created by Hu on 2017/7/7.
 */
public interface IUserDemoMapperDAO {
	
	public int insertUser(UserDemo user);

    public List<UserDemo> getUser(String name);

}


