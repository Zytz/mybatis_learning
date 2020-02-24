package com.john.sqlSession;

import com.john.builder.Configuration;
import com.john.builder.MapperStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/22
 * @description:
 */
public interface Executor {
    public <E>List<E> query(Configuration configuration, MapperStatement mapperStatement,Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IntrospectionException, InstantiationException, InvocationTargetException;


}
