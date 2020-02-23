package com.john.dao;

import com.john.pojo.User;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/22
 * @description:
 */
public interface IUserDao {
   public User findOne(int id, String username);
   public List<User> findList();
}
