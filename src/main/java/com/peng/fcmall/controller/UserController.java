package com.peng.fcmall.controller;

import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.impl.AdminServiceImpl;
import com.peng.fcmall.service.impl.OrderServiceImpl;
import com.peng.fcmall.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/23 22:47
 * @Version 1.0
 */
@RequestMapping("/user/**")
@Controller
public class UserController {

    /*
    生成UserServiceImpl对象
     */
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private User user;

    /**
     * 跳转注册登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "registerOrLogin";
    }
    /*
    * 以POST请求 路径为 /user/login 的访问方式
    * 成功跳转：index.jsp 失败跳转：registerOrLogin.jsp
    * */
    @PostMapping("/login")
    public String login(LoginBean info, HttpSession session){
        user = userService.Login(info);
        if (user != null){
            //登陆成功就将用户信息放入会话对象
            session.setAttribute("userInfo", user);
            return "index";
        } else {
            return "registerOrLogin";
        }
    }
    /*
     * 以POST请求 路径为 /user/register 的访问方式
     * 成功跳转：index.jsp 失败跳转：registerOrLogin.jsp
     * */
    @PostMapping("/register")
    public String register(User user){
        System.out.println(user.toString());
        if (userService.Register(user)) {
            return "index";
        }else {
            return "registerOrLogin";
        }
    }

    @RequestMapping("/PersonalCenter")
    public String personalCenter(){
        return "userInfo";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, HttpSession session){
        if (userService.Delete(id))
            session.invalidate();
        return "index";
    }

    @RequestMapping("/update")
    public String update(HttpSession session){
        return "userUpdateInfo";
    }

    @PostMapping("/update")
    public String update(User user,HttpSession session){
        if (userService.Update(user))
            session.setAttribute("userInfo", user);
        return "userInfo";
    }

    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("/user/admin/{page}")
    public String allUser(HttpSession session, ServletRequest request, @PathVariable Integer page,String is){
        //总行数：连接数据库获取
        int countLine = 0;
        //当前页数：默认第一页
        int currentPage = 1;
        //每页显示数：可指定
        int countSize = 5;
        //总共多少页：需计算
        int countPage = 0;

        //获取总页数
        countLine = adminService.getCount(is);
        request.setAttribute("countLine", countLine);

        //计算总页数：整除正好，有余则需多加一页
        if (countLine % countSize == 0)
            countPage = countLine / countSize;
        else
            countPage = (countLine / countSize) + 1;

        //获取当前页
        if (page != null)
            currentPage = page;

        List<User> userList = adminService.getAllUserInfo(is, (currentPage - 1) * countSize, countSize);

        //如果存在则先移除
        if(session.getAttribute("userList") != null){
            session.removeAttribute("userList");
        }
        //如果存在则先移除
        if(request.getAttribute("n") != null){
            request.removeAttribute("n");
        }
        session.setAttribute("userList", userList);
        request.setAttribute("n", countPage);
        //查询所有用户信息
        session.setAttribute("userList", userList);
        return "admin_userList";
    }

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/order")
    public String getOrder(HttpSession session){
        session.setAttribute("orderList", orderService.getOrder());
        return "admin_userOrder";
    }
}
