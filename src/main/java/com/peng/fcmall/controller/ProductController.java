package com.peng.fcmall.controller;

import com.peng.fcmall.dao.impl.OrderDaoImpl;
import com.peng.fcmall.pojo.Car;
import com.peng.fcmall.pojo.Orders;
import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 21:42
 * @Version 1.0
 */
@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private Product product;
    @Autowired
    private ProductService productService;
    @Autowired
    private Orders orders;
    @Autowired
    private User user;
    @Autowired
    private OrderDaoImpl orderDao;

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, ServletRequest request){
        product = productService.getAllProduct(id);
        request.setAttribute("product", product);
        return "productDetail";
    }

    @PostMapping("/buy")
    public String buy(Integer id, Integer num, HttpSession session){
        if (session.getAttribute("userInfo") == null)
            return "registerOrLogin";
        Car car = new Car();
        product = productService.getAllProduct(id);
        List<Car> carList = null;
        if(product.getPNum() >= num){
            productService.setReducePNum(id, num);
            if(session.getAttribute("carList") == null)
                carList = new ArrayList<>();
            else{
                carList = (List<Car>)session.getAttribute("carList");
            }
            car.setNum(num);
            car.setProduct(product);
            carList.add(car);
            session.setAttribute("carList", carList);
            return "redirect:/nav/car";
        }
        return "index";

    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable Integer id, Integer num, HttpSession session){
        List<Car> carList = (List<Car>)session.getAttribute("carList");
        List<Car> carLists = new ArrayList<>();;
        for (Car c : carList){
            if (id == c.getProduct().getPID()){
                if(num < c.getNum()){
                    c.setNum(c.getNum() - num);
                    carLists.add(c);
                }
                //商品回增
                productService.setAddPNum(c.getProduct().getPID(), num);
            }else{
                carLists.add(c);
            }
        }
        session.setAttribute("carList", carLists);
        if (carLists == null && carLists.size() == 0){
            session.removeAttribute("carList");
        }
        return "redirect:/nav/car";
    }

    @RequestMapping("/all")
    public String removeAll(HttpSession session) throws InterruptedException {
        List<Car> carList = (List<Car>)session.getAttribute("carList");
        int countPrice = 0;
        for (Car c: carList) {
            countPrice += (c.getNum() * (int)c.getProduct().getPPrice());
        }
        user =  (User)session.getAttribute("userInfo");
        orders.setPrice(countPrice);
        orders.setUser_id(user.getId());

        orderDao.createOrder(orders);


        if (session.getAttribute("carList") != null){
            session.removeAttribute("carList");
        }
        Thread.currentThread().sleep(1500);
        return "redirect:/nav/car";
    }
}
