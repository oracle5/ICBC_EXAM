package cn.icbc.fruits;

import cn.icbc.fruits.base.Fruit;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 草莓水果
 */
public class Strawberry extends Fruit {
    public Strawberry(String name, double price) {
        super(name, price);
    }

    public Strawberry(String name, double price, BigDecimal discountRate) {
        super(name, price, discountRate);
    }
}
