package cn.icbc.enums;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Charlie
 * @Date: 2025/02/10
 * @Description: 水果枚举
 */
public enum FruitsEnum {

    APPLE("apple",8.00,"斤"),
    STRAWBERRY("strawberry",13.00,"斤"),
    MANGO("mango",20.00,"斤")
    ;


    FruitsEnum(String name, Double price, String unit) {
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    /**
     * 名字
     */
    private String name;

    /**
     * 价钱
     */
    private Double price;

    /**
     * 单位
     */
    private String unit;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }
}
