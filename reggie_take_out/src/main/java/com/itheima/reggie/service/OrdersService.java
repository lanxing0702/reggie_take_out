package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

public interface OrdersService extends IService<Orders> {
  void submit(Orders paramOrders);
}


/* Location:              F:\新建文件夹\classes\!\com\itheima\reggie\service\OrdersService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */