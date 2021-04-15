package com.georve.business;

import com.georve.domain.Stock;

import java.util.Optional;
import java.util.Set;

public class MaquinaExpendedora {
    private Set<Stock> stock;
    private Integer dineroToReturn=0;
    private Integer dineroCliente=0;

    public MaquinaExpendedora(Set<Stock> stock, Integer dineroToReturn) {
        this.stock = stock;
        this.dineroToReturn = dineroToReturn;
    }

    public void maquinaReinicio(Set<Stock> stock, Integer dineroToReturn){
        this.stock = stock;
        this.dineroToReturn = dineroToReturn;
    }

    public void comprar(Integer machineOption){
        //dineroCliente=dinero;
        System.out.println("MachineOption:"+machineOption);
        if(dineroToReturn>0){
            Stock result = this.stock.stream().filter(e -> e.getProducto().getMachineOption().equals(machineOption))
                    .findFirst()
                    .orElse(null);
            if(result!=null){
               if( result.getQty()>0){
                   if(dineroCliente>=result.getProducto().getPrice()){

                       Integer vuelto=dineroCliente-result.getProducto().getPrice();
                       if(dineroToReturn>vuelto){
                           result.discountProduct();
                           System.out.println("Producro vendido:"+result.getProducto().getName()+"vuelto:"+vuelto);
                           dineroToReturn-=vuelto;
                           dineroToReturn+=dineroCliente;
                           dineroCliente=0;
                       }else{
                           System.out.println("No vuelto disponible, deposite cantidad exacta");
                       }

                   }else {
                       System.out.println("No tiene dinero suficiente, deposite cantidad exacta");
                   }
               }else{
                   System.out.println("Producto no disponible, intente otro producto");
               }
            }else{
                System.out.println("Producto no encontrado en las opciones");
            }


        }else{
            System.out.println("No hay vuelto disponible para hacer la compra");
        }
    }
    public Integer returnDineroCliente(){
        if(dineroCliente>0){
            return this.dineroCliente;
        }
        return 0;
    }

    public void depositarDinero(Integer dinero){
        dineroCliente=dinero;
    }

    public Set<Stock> getStock() {
        return stock;
    }

    public void setStock(Set<Stock> stock) {
        this.stock = stock;
    }

    public Integer getDineroToReturn() {
        return dineroToReturn;
    }

    public void setDineroToReturn(Integer dineroToReturn) {
        this.dineroToReturn = dineroToReturn;
    }

    public Integer getDineroCliente() {
        return dineroCliente;
    }

    public void setDineroCliente(Integer dineroCliente) {
        this.dineroCliente = dineroCliente;
    }
}
