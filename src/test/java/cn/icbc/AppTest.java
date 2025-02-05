package cn.icbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.icbc.fruits.Apple;
import cn.icbc.fruits.Mango;
import cn.icbc.fruits.Strawberry;
import cn.icbc.fruits.base.Fruit;
import cn.icbc.shop.Discount;
import cn.icbc.shop.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * 单元测试类
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * 第一题单元测试
     */
    @Test
    public void testExamOne() {
        Fruit apple = new Apple("apple",8);
        Fruit starwberry = new Strawberry("starwberry", 13);
        ShoppingCart cart = new ShoppingCart();
        //苹果数量
        BigDecimal appleQty=new BigDecimal("10000023234526346363262");
        //草莓数量
        BigDecimal starwberryQty = new BigDecimal("345");
        //买入
        cart.addFruit(apple, appleQty);
        cart.addFruit(starwberry,starwberryQty);

        //计算预期总价
        BigDecimal appLeValue = new BigDecimal(apple.getPrice()).multiply(appleQty);
        BigDecimal starwberryValue=new BigDecimal(starwberry.getPrice()).multiply(starwberryQty);
        BigDecimal totalExpected=appLeValue.add(starwberryValue);

        System.out.println("买入苹果斤数："+appleQty.toString());
        System.out.println("买入草莓斤数："+starwberryQty.toString());
        System.out.println("第一题买入总价："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第二题单元测试
     */
    @Test
    public void testExamTwo() {
        Fruit apple = new Apple("apple",8);
        Fruit starwberry = new Strawberry("starwberry", 13);
        Fruit mango =new Mango("mango",20);

        ShoppingCart cart = new ShoppingCart();
        //苹果数量
        BigDecimal appleQty=new BigDecimal("34653461");
        //草莓数量
        BigDecimal starwberryQty = new BigDecimal("1345345");
        //芒果数量
        BigDecimal mangoQty = new BigDecimal("199999896786");
        //买入
        cart.addFruit(apple, appleQty);
        cart.addFruit(starwberry,starwberryQty);
        cart.addFruit(mango,mangoQty);

        //计算预期总价
        BigDecimal appLeValue = new BigDecimal(apple.getPrice()).multiply(appleQty);
        BigDecimal starwberryValue=new BigDecimal(starwberry.getPrice()).multiply(starwberryQty);
        BigDecimal mangoValue=new BigDecimal(mango.getPrice()).multiply(mangoQty);

        BigDecimal totalExpected=appLeValue.add(starwberryValue).add(mangoValue);

        System.out.println("买入苹果斤数："+appleQty.toString());
        System.out.println("买入草莓斤数："+starwberryQty.toString());
        System.out.println("买入mango斤数："+mangoQty.toString());

        System.out.println("第二题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第三题单元测试
     */
    @Test
    public void testExamThree() {
        Fruit apple = new Apple("apple",8);
        Fruit starwberry = new Strawberry("starwberry", 13,Discount.STRAWBERRY_DISCOUNT_RATE);
        Fruit mango =new Mango("mango",20);

        ShoppingCart cart = new ShoppingCart();
        //苹果数量
        BigDecimal appleQty=new BigDecimal("10");
        //草莓数量
        BigDecimal starwberryQty = new BigDecimal("100");
        //芒果数量
        BigDecimal mangoQty = new BigDecimal("10");
        //买入
        cart.addFruit(apple, appleQty);
        cart.addFruit(starwberry,starwberryQty);
        cart.addFruit(mango,mangoQty);

        //计算预期总价
        BigDecimal appLeValue = new BigDecimal(apple.getPrice()).multiply(appleQty);
        BigDecimal starwberryValue=new BigDecimal(starwberry.getPrice()).multiply(starwberryQty).multiply(Discount.STRAWBERRY_DISCOUNT_RATE);
        BigDecimal mangoValue=new BigDecimal(mango.getPrice()).multiply(mangoQty);

        BigDecimal totalExpected=appLeValue.add(starwberryValue).add(mangoValue);

        System.out.println("买入苹果斤数："+appleQty.toString());
        System.out.println("买入草莓斤数："+starwberryQty.toString());
        System.out.println("买入mango斤数："+mangoQty.toString());

        System.out.println("第三题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第四题单元测试
     */
    @Test
    public void testExamFour() {
        Fruit apple = new Apple("apple",8);
        Fruit starwberry = new Strawberry("starwberry", 13,Discount.STRAWBERRY_DISCOUNT_RATE);
        Fruit mango =new Mango("mango",20);

        ShoppingCart cart = new ShoppingCart();
        //苹果数量
        BigDecimal appleQty=new BigDecimal("10");
        //草莓数量
        BigDecimal starwberryQty = new BigDecimal("100");
        //芒果数量
        BigDecimal mangoQty = new BigDecimal("10");

        //买入
        cart.addFruit(apple, appleQty);
        cart.addFruit(starwberry,starwberryQty);
        cart.addFruit(mango,mangoQty);

        //计算预期总价
        BigDecimal appLeValue = new BigDecimal(apple.getPrice()).multiply(appleQty);
        BigDecimal starwberryValue=new BigDecimal(starwberry.getPrice()).multiply(starwberryQty).multiply(Discount.STRAWBERRY_DISCOUNT_RATE);
        BigDecimal mangoValue=new BigDecimal(mango.getPrice()).multiply(mangoQty);

        //期望的金额
        BigDecimal totalExpected=appLeValue.add(starwberryValue).add(mangoValue);
        BigDecimal discountTimes = totalExpected.divide(Discount.DISCOUNT_MAX_PRICE, 0,BigDecimal.ROUND_DOWN);
        System.out.println("满减次数："+discountTimes);
        BigDecimal totalDiscount = Discount.DISCOUNT_PRICE.multiply(discountTimes);
        totalExpected= totalExpected.subtract(totalDiscount);

        System.out.println("买入苹果斤数："+appleQty.toString());
        System.out.println("买入草莓斤数："+starwberryQty.toString());
        System.out.println("买入mango斤数："+mangoQty.toString());

        System.out.println("第四题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotalForReduction(Discount.DISCOUNT_MAX_PRICE, Discount.DISCOUNT_PRICE));
    }

}
