package com.georve.domain;

public class Stock {
    private Producto producto;
    private Integer qty;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer discountProduct(){
        this.qty--;
        return this.getQty();
    }

    public Stock(Producto producto, Integer qty){
        this.producto=producto;
        this.qty=qty;
    }
}
