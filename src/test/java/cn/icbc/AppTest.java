package cn.icbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.icbc.enums.FruitsEnum;
import cn.icbc.fruits.Apple;
import cn.icbc.fruits.Mango;
import cn.icbc.fruits.Strawberry;
import cn.icbc.fruits.base.Fruit;
import cn.icbc.shop.Discount;
import cn.icbc.shop.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

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
        Fruit apple = new Apple(FruitsEnum.APPLE.getName(),FruitsEnum.APPLE.getPrice());
        Fruit starwberry = new Strawberry(FruitsEnum.STRAWBERRY.getName(), FruitsEnum.STRAWBERRY.getPrice());
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

        for(Map.Entry<Fruit, BigDecimal> item: cart.getItems().entrySet()){
            System.out.println("买入水果"+item.getKey().getName()+"每斤/元："+item.getKey().getPrice()+"买入斤数："+item.getValue().toString());
        }
        System.out.println("第一题买入总价："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第二题单元测试
     */
    @Test
    public void testExamTwo() {
        Fruit apple = new Apple(FruitsEnum.APPLE.getName(),FruitsEnum.APPLE.getPrice());
        Fruit starwberry = new Strawberry(FruitsEnum.STRAWBERRY.getName(), FruitsEnum.STRAWBERRY.getPrice());
        Fruit mango =new Mango(FruitsEnum.MANGO.getName(),FruitsEnum.MANGO.getPrice());

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

        for(Map.Entry<Fruit, BigDecimal> item: cart.getItems().entrySet()){
            System.out.println("买入水果"+item.getKey().getName()+"每斤/元："+item.getKey().getPrice()+"买入斤数："+item.getValue().toString());
        }

        System.out.println("第二题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第三题单元测试
     */
    @Test
    public void testExamThree() {
        Fruit apple = new Apple(FruitsEnum.APPLE.getName(),FruitsEnum.APPLE.getPrice());
        Fruit starwberry = new Strawberry(FruitsEnum.STRAWBERRY.getName(), FruitsEnum.STRAWBERRY.getPrice(),Discount.STRAWBERRY_DISCOUNT_RATE);
        Fruit mango =new Mango(FruitsEnum.MANGO.getName(),FruitsEnum.MANGO.getPrice());

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


        for(Map.Entry<Fruit, BigDecimal> item: cart.getItems().entrySet()){
            System.out.println("买入水果"+item.getKey().getName()+"每斤/元："+item.getKey().getPrice()+"买入斤数："+item.getValue().toString());
        }

        System.out.println("第三题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotal());
    }

    /**
     * 第四题单元测试
     */
    @Test
    public void testExamFour() {
        Fruit apple = new Apple(FruitsEnum.APPLE.getName(),FruitsEnum.APPLE.getPrice());
        Fruit starwberry = new Strawberry(FruitsEnum.STRAWBERRY.getName(), FruitsEnum.STRAWBERRY.getPrice(),Discount.STRAWBERRY_DISCOUNT_RATE);
        Fruit mango =new Mango(FruitsEnum.MANGO.getName(),FruitsEnum.MANGO.getPrice());

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

        boolean loop =true;
        if(loop){
            //逐次满减 期望的金额
            BigDecimal discountTimes = totalExpected.divide(Discount.DISCOUNT_MAX_PRICE, 0,BigDecimal.ROUND_DOWN);
            System.out.println("满减次数："+discountTimes);
            BigDecimal totalDiscount = Discount.DISCOUNT_PRICE.multiply(discountTimes);
            totalExpected= totalExpected.subtract(totalDiscount);
        }else {
            //一次性满减金额
            if (totalExpected.compareTo(Discount.DISCOUNT_MAX_PRICE) > 0) {
                //大于满减的钱
                totalExpected = totalExpected.subtract(Discount.DISCOUNT_PRICE);
            }
        }


        for(Map.Entry<Fruit, BigDecimal> item: cart.getItems().entrySet()){
            System.out.println("买入水果"+item.getKey().getName()+"每斤/元："+item.getKey().getPrice()+"买入斤数："+item.getValue().toString());
        }

        System.out.println("第四题买入总价元："+totalExpected);

        //对比总价
        assertEquals(totalExpected, cart.calculateTotalForReduction(Discount.DISCOUNT_MAX_PRICE, Discount.DISCOUNT_PRICE,loop));
    }

}
