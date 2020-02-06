package ru.pts28;

//формирование шаблона для JSON_1, JSON_2
public class ClassMark {
    private String key;
    private Integer quantity;


    public ClassMark(String key, Integer quantity) {
        this.key = key;
        this.quantity = quantity;

    }

    public String getKey() {
        return key;
    }

    public Integer getQuantity() {
        if (quantity==null) {quantity= (Integer) null;}
        return quantity;
    }
}