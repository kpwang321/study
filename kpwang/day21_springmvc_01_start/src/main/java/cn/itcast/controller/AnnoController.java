package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author kpwang
 * @create 2020-07-10 14:49
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {


    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(username);
        return "success";
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(body);
        return "success";
    }
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("testCookieValue执行了。。。。");
        System.out.println(cookie);
        return "success";
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了。。。。");
        System.out.println(user);
        return "success";
    }
    //该方法先执行
    @ModelAttribute
    public void showUser(String uname,Map<String ,User> map){
        System.out.println("showUser执行力");
        //通过用户名查数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc" ,user);
    }
   /* @ModelAttribute
    public User  showUser(String uname){
        System.out.println("showUser执行力");
        //通过用户名查数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/
   @RequestMapping("/testSessionAttributes")
   public String testSessionAttributes(Model model){
       System.out.println("testSessionAttributes执行了。。。。");
       model.addAttribute("msg","赵丽颖");
       return "success";
   }
   @RequestMapping("/getSessionAttributes")
   public String getSessionAttributes(ModelMap modelMap){
       System.out.println("testSessionAttributes执行了。。。。");
       String msg = (String) modelMap.get("msg");
       System.out.println(msg);
       return "success";
   }
}
