package cn.icbc.shop;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 打折参数
 */
public interface Discount {

        //不打折
        public static final BigDecimal NOT_DISCOUNT_RATE = new BigDecimal("1");

        //8折
        public static final BigDecimal STRAWBERRY_DISCOUNT_RATE = new BigDecimal("0.8");

        //满减,满100减10
        public static final BigDecimal DISCOUNT_MAX_PRICE = new BigDecimal("100");
        public static final BigDecimal DISCOUNT_PRICE = new BigDecimal("10");

}
