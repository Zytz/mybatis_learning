package com.john.sqlSession;

import com.john.pojo.Configuration;

/**
 * @author:wenwei
 * @date:2020/02/22
 * @description:
 */
public class DefaultSqlsessionFactory  implements SqlSessionFactory{
    private Configuration configuration;

    public DefaultSqlsessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlsession(configuration);
    }
}
