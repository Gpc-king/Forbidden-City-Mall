package com.peng.fcmall.controller;

import com.peng.fcmall.Utils.PageUtil;
import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 17:22
 * @Version 1.0
 */
@RequestMapping("/nav/**")
@Controller
public class NavController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/car")
    public String car(HttpSession session){
        if (session.getAttribute("userInfo") == null)
            return "registerOrLogin";
        return "car";
    }

//    @RequestMapping("/all")
//    public String all(HttpSession session){
//        List<Product> productInfos = productService.getAllProduct();
//        session.setAttribute("productInfos", productInfos);
//        return "productList";
//    }
//
//    @RequestMapping("/all/{cate}")
//    public String allByCate(@PathVariable String cate, HttpSession session){
//        List<Product> productInfos = productService.getAllProductByCate(cate);
//        session.setAttribute("productInfos", productInfos);
//        return "productList";
//    }

    @Autowired
    private PageUtil pageUtil;

    @RequestMapping("/all/{page}/{is}")
    public String allUser(HttpSession session, ServletRequest request, @PathVariable Integer page,
                          @PathVariable String is){
        int countLine = productService.getCount(is);
        int[] pages = pageUtil.PaginationView(countLine, page);
        List<Product> productList = productService.getAllProduct(is, pages[0], pages[1]);

        //如果存在则先移除
        if(session.getAttribute("productInfos") != null){
            session.removeAttribute("productInfos");
        }
        //如果存在则先移除
        if(request.getAttribute("np") != null){
            request.removeAttribute("np");
        }
        //如果存在则先移除
        if(request.getAttribute("isWhat") != null){
            request.removeAttribute("isWhat");
        }
        request.setAttribute("np", pages[2]);
        //查询所有信息
        session.setAttribute("productInfos", productList);
        session.setAttribute("isWhat", is);
        return "productList";
    }


}
