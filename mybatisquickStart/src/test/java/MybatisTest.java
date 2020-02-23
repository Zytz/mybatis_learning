import com.john.mapper.OrderMapper;
import com.john.mapper.UserMapper;
import com.john.pojo.Order;
import com.john.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/22
 * @description:
 */
public class MybatisTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        List<User> objects = sqlSession.selectList("user.findAll");
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void saveTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        User user = new User();
        user.setId(4);
        user.setUsername("tom");
        int insert = sqlSession.insert("user.saveUser", user);
        //默认不提交事务
        sqlSession.commit();

    }

    @Test
    public void updateTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        User user = new User();
        user.setId(4);
        user.setUsername("tom_updated");
        int insert = sqlSession.update("user.updateUser", user);
        //默认不提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        int insert = sqlSession.update("user.deleteUser", 3);
        //默认不提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void tableLinkTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//        List<Order> orders = mapper.findAll();
//        for (Order o : orders) {
//            System.out.println(o);
//
//        }
    }

    @Test
    public void mulTableLinkTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> orders = mapper.findAll();
        for (User o : orders) {
            System.out.println(o);

        }
    }

    @Test
    public void annotionTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> orders = mapper.findAll();
        for (User o : orders) {
            System.out.println(o);

        }
    }


    UserMapper userMapper;
    OrderMapper orderMapper;

    @Before
    public void befor() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);

        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(4);
        user.setUsername("annotionTest");
        userMapper.addUser(user);

    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("update test");
        userMapper.updateUser(user);

    }

    @Test
    public void selectUser() {
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);

        }

    }

    @Test
    public void DeleteUser() {
        userMapper.deleteUser(4);


    }

    @Test
    public void oneToOneTest() {

        List<Order> orderAndUser = orderMapper.findOrderAndUser();
        for (Order soo : orderAndUser) {
            System.out.println(soo);
        }

    }
    @Test
    public void oneToManyTest() {

        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

    }
    @Test
    public void manyToManyTest() {

        List<User> userList = userMapper.findAllUserAndRole();
        for (User user : userList) {
            System.out.println(user);
        }

    }
}
