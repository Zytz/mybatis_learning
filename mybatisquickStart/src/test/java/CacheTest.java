import com.john.mapper.OrderMapper;
import com.john.mapper.UserMapper;
import com.john.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
public class CacheTest {

    UserMapper userMapper;
    OrderMapper orderMapper;
    SqlSession sqlSession;
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void befor() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);

        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testFirstLevelCache() {
        User userById = userMapper.findUserById(1);
        userById.setUsername("update___");
        userById.setId(1);
        userMapper.updateUser(userById);
        sqlSession.commit();


        User userById1 = userMapper.findUserById(1);

        System.out.println(userById == userById1);
    }
    @Test
    public void testSecondLevelCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);


        User userById = mapper.findUserById(1);
        sqlSession.close();//清空一级缓存

        User userById1 = mapper1.findUserById(1);

        System.out.println(userById == userById1);

    }
}