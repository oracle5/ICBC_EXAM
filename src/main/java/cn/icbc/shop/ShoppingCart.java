package cn.icbc.shop;

import cn.icbc.fruits.base.Fruit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/04
 * @Description: 購物車
 */
public class ShoppingCart {

    //存放水果的map
    private Map<Fruit, BigDecimal> items = new HashMap<>(); //斤数使用BigDecimal类型防止溢出

    /**
     * 买水果方法，往里面放
     *
     * @param fruit
     * @param qty
     */
    public void addFruit(Fruit fruit, BigDecimal qty) {
        if (Objects.isNull(qty) || qty.compareTo(BigDecimal.ZERO)< 0) {
            System.out.println("===>购买数量不能为负数");
            throw new RuntimeException("数量不能为负数");
        }
        //放水果入，累加
        items.put(fruit, items.getOrDefault(fruit, BigDecimal.ZERO).add( qty));
    }

    // 计算总价
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Fruit, BigDecimal> entry : items.entrySet()) {
            BigDecimal price = new BigDecimal(entry.getKey().getPrice());
            BigDecimal qty = entry.getValue();
            BigDecimal discountRate = entry.getKey().getDiscountRate();
            if (discountRate.compareTo(BigDecimal.ONE) > 0 || discountRate.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("==>打折率不正常，请检查，打折率：" + discountRate);
                throw new RuntimeException("打折率不正常，请检查!");
            }
            //金额*数量*打折率 =总价
            total = total.add(price.multiply(qty).multiply(discountRate));
        }
        return total;
    }

    /**
     * 打折后的总结
     * @param discountRate 打折率
     * @return
     */
    @Deprecated
    public BigDecimal calculateTotalForDiscount(BigDecimal discountRate) {
        if (discountRate.compareTo(BigDecimal.ONE) > 0 || discountRate.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("==>打折率不正常，请检查，打折率：" + discountRate);
            throw new RuntimeException("打折率不正常，请检查!");
        }
        BigDecimal total = calculateTotal();
        //计算总价后*打折力度
        return total.multiply(discountRate);
    }



    /**
     * 满减的时候计算总价
     * @param discountMaxPrice 满多少元
     * @param discountPrice 减多少元
     * @return
     */
    public BigDecimal calculateTotalForReduction(BigDecimal discountMaxPrice, BigDecimal discountPrice) {
        if (Objects.isNull(discountMaxPrice) ||Objects.isNull(discountPrice)|| discountPrice.compareTo(BigDecimal.ZERO) < 0 || discountMaxPrice.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("===>非法参数");
            throw new RuntimeException("非法参数，请检查!");
        }
        BigDecimal total = calculateTotal();
        //计算满减的次数 0 取整
        BigDecimal discountTimes = total.divide(discountMaxPrice,0, BigDecimal.ROUND_DOWN);
        //总折扣金额
        BigDecimal totalDiscount = discountPrice.multiply(discountTimes);
        total= total.subtract(totalDiscount);
        //如果满减后不用给钱，返回0，表示免费
        return total.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : total;
    }
}
