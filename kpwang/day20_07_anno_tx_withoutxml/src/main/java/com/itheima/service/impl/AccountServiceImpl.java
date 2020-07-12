package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kpwang
 * @create 2020-07-09 16:26
 */

@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer.......");
        //1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2根据名称查询转入账号
        Account target = accountDao.findAccountByName(targetName);
        //3转出账户减钱
        if (source.getMoney() - money < 0) {
            throw new RuntimeException("账号余额不足");
        } else {
            source.setMoney(source.getMoney() - money);
        }
        //4转入账号加钱
        target.setMoney(target.getMoney() + money);
        //5更新转出账号
        accountDao.updateAccount(source);
        //int i = 1 / 0;
        //6跟新转入账号
        accountDao.updateAccount(target);
    }
}
