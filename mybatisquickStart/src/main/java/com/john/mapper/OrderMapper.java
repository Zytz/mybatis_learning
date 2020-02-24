package com.john.mapper;

import com.john.builder.Order;
import com.john.builder.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
public interface OrderMapper {
//
//    List<Order> findAll();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderName", column = "order_name"),
            @Result(property = "user", column = "uid", javaType = User.class, one = @One(select = "com.john.mapper.UserMapper.findUserById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser();

    @Results({@Result(property = "id", column = "id"),
            @Result(property = "orderName", column = "order_name")})
    @Select("select * from orders where uid=#{uid}")
    public List<Order> findOrderByUid(Integer uid);


}
