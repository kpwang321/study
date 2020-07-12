package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kpwang
 * @create 2020-07-07 1:48
 * 曾经xml的配置
 * <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *        scope=""  init-method=""  destroy-method="" >
 *     <property name="" value="" | ref=""></property>
 * </bean>
 * 用于创建对象的
 *     他们的作用就和xml配置文件中编写一个<bean> 标签实现的功能是一样的
 *     @Component:把当前类对象存入spring容器中
 *     属性value :指定bean的id。当不写时默认值为当前类名首字母改小写
 *     @Controller
 *     @Service
 *     @Repository
 *     以上三个注解和component时一样的。时spring框架为我们提供明确的三层注解
 *
 * 用于注入数据的
 *     和在xml配置文件中的bean标签中的property标签的作用一样
 *     Autowired:自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配。就可以注入成功
 *     细节:在使用注解注入时，set方法就不是必须的了
 *     @Qualifier 作用 在按照类中注入的基础之上再按照名称注入。它给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *     @Resource 直接按照bean的id注入。可以独立使用
 *           属性 name  用于指定bean的id
 * 用于改变作用范围的
 *     和在bean标签中scope的作用一样
 * 生命周期相关
 *     和在bean标签中init-method=""  destroy-method=""的作用一样
 */
@Component(value = "accountService")
public class AccountServiceImpl implements IAccountService {
    //@Autowired
    //@Qualifier(value = "accountDao2")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;


    public void saveAccount() {
        accountDao.saveAccount();
    }
}
