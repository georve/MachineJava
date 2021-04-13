package com.georve.domain;

public class Producto {
    private String name;
    private Integer price;
    private Integer machineOption;

    public Integer getMachineOption() {
        return machineOption;
    }

    public void setMachineOption(Integer machineOption) {
        this.machineOption = machineOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Producto(String nombre, Integer price,Integer machineOption){
        this.name=nombre;
        this.price=price;
        this.machineOption=machineOption;
    }
}
