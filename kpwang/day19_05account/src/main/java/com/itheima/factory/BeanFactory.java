package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kpwang
 * @create 2020-07-08 16:38
 */
public class BeanFactory {
    private IAccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return  (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            txManager.beginTransaction();
                            method.invoke(accountService, args);
                            txManager.commit();
                            return rtValue;
                        } catch (Exception e) {
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            txManager.release();
                        }

                    }
                });
    }


}
