package com.peng.fcmall.controller;

import com.peng.fcmall.Utils.ExcelUtil;
import com.peng.fcmall.dao.impl.UserDaoImpl;
import com.peng.fcmall.pojo.OrderItem;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.impl.AdminServiceImpl;
import com.peng.fcmall.service.impl.OrderServiceImpl;
import com.peng.fcmall.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @Author Peng
 * @Date 2022/4/26 15:37
 * @Version 1.0
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private User user;

    @RequestMapping("/view/{id}")
    public String getUserByID(@PathVariable Integer id, HttpSession session) {
        session.setAttribute("userID", adminService.getUserInfoByID(id));
        return "admin_userView";
    }

    @PostMapping("/insert")
    public String insetUser(User user) {
        user.toString();
        userDao.Register(user);
        return "redirect:/user/admin/1";
    }

    @RequestMapping("/update/{id}")
    public String updateInfo(@PathVariable Integer id, HttpSession session) {
        session.setAttribute("updateUser", userService.selectByID(id));
        return "admin_userUpdate";
    }

    @PostMapping("/update")
    public String update(User user) {
        userService.Update(user);
        return "redirect:/user/admin/1";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, HttpSession session){
        user = (User)session.getAttribute("userInfo");
        userService.Delete(id);
        if(user.getId() == id){
            session.invalidate();
            return "redirect:/registerOrLogin";
        }else{
            return "redirect:/user/admin/1";
        }
    }

    @RequestMapping("/out")
    private String createList(HttpServletResponse response) throws IOException {
        List<User> user = adminService.getAllUserInfo();
        if(null == user) {
            return null;
        }
        String[] keys = {"id", "name", "memberCode", "password","gender", "phoneNo", "email", "address", "types"};
        String[] excelHeader = {"ID", "姓名", "会员码", "密码","性别", "手机号", "邮箱", "地址", "身份"};
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("fileName", "用户表" + new Date().getTime());
        model.put("sheetName", "表一");
        model.put("title", "PALACE MALL后台管理系统--用户表");
        model.put("keys", keys);
        model.put("excelHeader", excelHeader);
        list.add(model);

        for(User u : user) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", u.getId());
            map.put("name", u.getUsername());
            map.put("memberCode", u.getMemberCode());
            map.put("password", u.getPassword());
            map.put("gender", u.getSex());
            map.put("phoneNo", u.getTel());
            map.put("email", u.getEmail());
            map.put("address", u.getAddress());
            map.put("types", u.isAdmin());
            list.add(map);
        }

        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.exportExcel(response, list);

        return "redirect:/user/admin/1";
    }

    @Autowired
    private OrderServiceImpl orderService;
    @RequestMapping("/outOrder")
    public String getOrderList(HttpServletResponse response) throws IOException {
        List<OrderItem> order = orderService.getOrder();
        if(null == order) {
            return null;
        }
        String[] keys = {"memberCode", "name", "price", "cate", "time"};
        String[] excelHeader = { "会员码", "姓名", "价钱", "方式", "时间"};
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("fileName", "订单表" + new Date().getTime());
        model.put("sheetName", "表一");
        model.put("title", "PALACE MALL后台管理系统--订单表");
        model.put("keys", keys);
        model.put("excelHeader", excelHeader);
        list.add(model);

        for(OrderItem o: order) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("memberCode", o.getMemberCode());
            map.put("name", o.getUsername());
            map.put("price", o.getPrice());
            map.put("cate", o.getCate());
            map.put("time", o.getTime());
            list.add(map);
        }

        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.exportExcel(response, list);
        return "admin_userOrder";
    }

}
