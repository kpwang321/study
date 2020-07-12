package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-10 22:12
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账号。。。");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存所有账号");
        accountDao.saveAccount(account);
        int i=1/0;
    }

    @Override
    public void fave(Account account) {
        System.out.println("业务层：保存所有账号");
        accountDao.saveAccount(account);
        int i=1/0;
    }
}
