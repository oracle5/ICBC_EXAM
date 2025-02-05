package cn.icbc.fruits;

import cn.icbc.fruits.base.Fruit;

import java.math.BigDecimal;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 芒果
 */
public class Mango extends Fruit {
    public Mango(String name, double price) {
        super(name, price);
    }

    public Mango(String name, double price, BigDecimal discountRate) {
        super(name, price, discountRate);
    }
}
