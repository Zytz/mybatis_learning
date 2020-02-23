package com.john.mapper;

import com.john.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
@CacheNamespace //开启二级缓存
public interface UserMapper {
    //查询所有用户、同时查询每个用户的订单
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "orderList",column = "id",
            javaType = List.class,
//                    namespace+id
                    many = @Many(select = "com.john.mapper.OrderMapper.findOrderByUid"))
    })
    @Select("select * from user")
    public List<User> findAll();


    //注解方式，添加用户
    @Insert("insert into user values(#{id},#{username})")
    public void addUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    public void updateUser(User user);

    @Select("select * from user")
    public List<User> selectUser();

    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    public User findUserById(Integer id);


    @Select("select * from user") @Results({
            @Result(id = true,property = "id",column = "id"), @Result(property = "username",column = "username"), @Result(property = "password",column = "password"), @Result(property = "birthday",column = "birthday"), @Result(property = "roleList",column = "id",
            javaType = List.class,
            many = @Many(select = "com.lagou.mapper.RoleMapper.findByUid"))
    })
    List<User> findAllUserAndRole();

}
