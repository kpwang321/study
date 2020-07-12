package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-10 22:15
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账号");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        //accountService.fave(account);
        accountService.saveAccount(account);
        return "list";
    }

}
