package com.peng.fcmall.Utils;

import org.springframework.stereotype.Repository;

/**
 * @Author Peng
 * @Date 2022/4/27 16:03
 * @Version 1.0
 */
@Repository
public class PageUtil {

    public int[] PaginationView(int countNum, Object page) {
        //总行数：连接数据库获取
        int countLine = 0;
        //当前页数：默认第一页
        int currentPage = 1;
        //每页显示数：可指定
        int countSize = 12;
        //总共多少页：需计算
        int countPage = 0;

        countLine = countNum;

        //计算总页数：整除正好，有余则需多加一页
        if (countLine % countSize == 0)
            countPage = countLine / countSize;
        else
            countPage = (countLine / countSize) + 1;

        //获取当前页
        if (page != null)
            currentPage = Integer.parseInt(String.valueOf(page));
        int[] arr = {(currentPage - 1) * countSize, countSize, countPage};
        return arr;
    }


}
