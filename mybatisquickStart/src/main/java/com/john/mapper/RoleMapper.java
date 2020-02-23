package com.john.mapper;

import org.apache.ibatis.annotations.Select;

import javax.management.relation.Role;

import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */

public interface RoleMapper {
    @Select("select * from role r,user_role ur where r.id=ur.role_id and ur.user_id =#{uid}")
    List<Role> findByUid(int uid);


}
