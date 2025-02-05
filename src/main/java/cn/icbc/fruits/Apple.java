package cn.icbc.fruits;

import cn.icbc.fruits.base.Fruit;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 苹果
 */
public class Apple extends Fruit {

    public Apple(String name,double price) {
        super(name,price);
    }

    public Apple(String name, double price, BigDecimal discountRate) {
        super(name, price, discountRate);
    }
}
