package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-10 22:10
 */
public interface AccountDao {
    //查询所有
    @Select("select * from account")
    List<Account> findAll();
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);
}
