package com.john.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author:wenwei
 * @date:2020/02/23
 * @description:
 */
@Intercepts({
        @Signature(type = StatementHandler.class,
        method = "prepare",
                args = {Connection.class,Integer.class}
        )
})
public class MyPlugins implements Interceptor {
    /**
     * 拦截方法，只要被拦截对西那个的目标方法执行，每次都会执行该方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("对方法进行了增强");
        return invocation.proceed();//原方法执行
    }

    /**
     * 把当前的拦截器生成代理生成到拦截器链中
     * @param target
     * @return
     */

    @Override
    public Object plugin(Object target) {
        System.out.println("plugin target");
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    /**
     * 获取配置文件的参数
     * @param properties
     */

    @Override
    public void setProperties(Properties properties) {
        System.out.println("获取到的参数: "+properties);
    }
}
