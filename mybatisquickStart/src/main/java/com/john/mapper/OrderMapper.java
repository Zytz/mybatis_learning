package com.john.mapper;

import com.john.pojo.Order;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
public interface OrderMapper {

    List<Order> findAll();

}
