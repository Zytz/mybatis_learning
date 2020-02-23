package com.john.mapper;

import com.john.pojo.User;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
public interface UserMapper {
    //查询所有用户、同时查询每个用户的订单
    public List<User> findAll();
}
