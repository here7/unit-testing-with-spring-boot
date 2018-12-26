package com.dheredia.unitesting.model;

public class Item {
    private final int quantity;
    private final int id;
    private final String name;
    private final int price;

    public Item(int id, String name, int price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return String.format("Item[%d, %s, %d, %d]", id,name,price,quantity);
    }
}
