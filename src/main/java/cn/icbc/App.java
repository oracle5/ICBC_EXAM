package cn.icbc;

import cn.icbc.fruits.Apple;
import cn.icbc.fruits.Mango;
import cn.icbc.fruits.Strawberry;
import cn.icbc.fruits.base.Fruit;
import cn.icbc.shop.Discount;
import cn.icbc.shop.ShoppingCart;

import java.math.BigDecimal;

/**
 * Hello world!
 */
@Deprecated
public class App {
    public static void main(String[] args) {

        //定义水果的价格
        Fruit apple = new Apple("apple", 8);
        Fruit strawberry = new Strawberry("Strawberry", 13);
        Fruit mongo = new Mango("mongo", 20);


        // 苹果和草莓，斤数极大
        ShoppingCart cartA = new ShoppingCart();
        cartA.addFruit(apple, new BigDecimal("10000023234526346363262"));//10000023234526346363262斤苹果
        cartA.addFruit(strawberry, new BigDecimal("10"));
        System.out.println("cartA : " + cartA.calculateTotal());

        BigDecimal total = new BigDecimal("10.00");
        BigDecimal discountMaxPrice = new BigDecimal("3.00");

        BigDecimal result = total.divide(discountMaxPrice, 2, BigDecimal.ROUND_DOWN);
        System.out.println("result: " + result);

    }
}
