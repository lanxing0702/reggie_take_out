package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.OrdersDto;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.entity.ShoppingCart;
import com.itheima.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 用户下单
     *
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据：{}", orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 查看全部订单
     * @param page
     * @param pageSize
     * @param number
     * @return
     */
    @GetMapping("/page")
    private R<Page> page(int page, int pageSize, String number) {
        Page<OrdersDto> dtoPage = orderService.dtoPage(page, pageSize, number, false);
        return R.success(dtoPage);
    }

    /**
     * 修改订单状态
     * @param orders
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Orders orders) {
        orderService.updateById(orders);
        return R.success("修改成功");
    }

    /**
     * 查看当前用户订单
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    private R<Page> userPage(int page, int pageSize) {
        Page<OrdersDto> dtoPage = orderService.dtoPage(page, pageSize, null, true);
        return R.success(dtoPage);
    }

    @PostMapping("/again")
    public R<String> again(@RequestBody  Orders orders){
        orderService.again(orders);
        return R.success("操作成功");
    }

}