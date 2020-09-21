package com.atguigu.gulimall.order.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//订单确认页需要的数据
@Data
public class OrderConfirmVo {
    //收货地址
    @Setter
    @Getter
    List<MemberAddressVo> adddress;
    //所有选中的购物项
    @Setter
    @Getter
    List<OrderItemVo> items;
    @Setter
    @Getter
    Map<Long, Boolean> stocks;

    @Setter
    @Getter
    String orderToken;


    public Integer getCount() {
        Integer count = 0;
        if (items != null && items.size() > 0) {
            for (OrderItemVo item : items) {
                count += item.getCount();
            }
        }
        return count;
    }

    //优惠卷信息
    @Setter
    @Getter
    private Integer integration;

    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if (items != null) {
            for (OrderItemVo item : items) {
                BigDecimal multipyt = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
                sum = sum.add(multipyt);
            }

        }
        return sum;
    }

    public BigDecimal getPayPrice() {
        return getTotal();
    }

}
