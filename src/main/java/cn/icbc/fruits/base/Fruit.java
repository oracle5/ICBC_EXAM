package cn.icbc.fruits.base;

import cn.icbc.shop.Discount;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 水果父类
 */
public abstract class Fruit {

    /**
     * 水果名字
     */
    protected String name;

    /**
     * 水果价格
     */
    protected double price;

    /**
     * 水果打折率
     */
    protected BigDecimal discountRate;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
        //默认是1 表示不打折
        this.discountRate = Discount.NOT_DISCOUNT_RATE;
    }

    public Fruit(String name, double price, BigDecimal discountRate) {
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }
}
