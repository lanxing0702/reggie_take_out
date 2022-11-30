package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.OrdersDto;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.entity.ShoppingCart;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);

    /**
     * 列表查询
     * @param page
     * @param pageSize
     * @param number
     * @return
     */
    Page<OrdersDto> dtoPage(int page, int pageSize, String number,boolean isId);

    /**
     * 再来一单
     * @param id
     * @return
     */
   void again(Orders orders);
}
