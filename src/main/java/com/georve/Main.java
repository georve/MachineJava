package com.georve;

import com.georve.business.MaquinaExpendedora;
import com.georve.domain.Producto;
import com.georve.domain.Stock;

import java.util.*;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args){
        List<Producto> productos=generarProductos();
        Set<Stock> stock=generateStockProductosAleatorio(productos);
        Integer moneyToReturn =200;
        MaquinaExpendedora maquina=new MaquinaExpendedora(stock,moneyToReturn);
        Integer option=0;
        Scanner sc=new Scanner(System.in);
        while(option!=4){
            try{
            System.out.println("Ingrese opcion:");
            System.out.println("1. Comprar");
            System.out.println("2. Devolver dinero");
            System.out.println("3. Reiniciar Maquina");
            System.out.println("4. Apagar Maquina");
            option=sc.nextInt();
            switch(option){
                case 1://comprar

                    String s= " ";
                    char c=' ';
                    while(c!='c'){
                        System.out.println("Ingrese Opcion de compra");
                        System.out.println("a . Deposito");
                        System.out.println("b. Seleccionar optiones");
                        System.out.println("c. volver al menu anterior");
                         s=sc.next();
                         c=s.charAt(0);
                        switch (c){
                            case 'a':

                                Integer optionDeposito=0;
                                Integer saldoAcumm=maquina.getDineroCliente();
                                while(optionDeposito!=5){
                                    System.out.println("Deposite monedas 1,5,10 y 15");
                                    System.out.println("1 . 1 Bs");
                                    System.out.println("2 . 5 Bs");
                                    System.out.println("3 . 10 Bs");
                                    System.out.println("4 . 25 Bs");
                                    System.out.println("5 . Salir");
                                    System.out.println("Saldo Acumulado:"+saldoAcumm);
                                    optionDeposito=sc.nextInt();
                                    switch(optionDeposito){
                                        case 1:
                                            saldoAcumm+=1;
                                            break;
                                        case 2:
                                            saldoAcumm+=5;
                                            break;
                                        case 3:
                                            saldoAcumm+=10;
                                            break;
                                        case 4:
                                            saldoAcumm+=25;
                                            break;
                                        default:
                                            maquina.depositarDinero(saldoAcumm);
                                            optionDeposito=5;
                                    }

                                }

                                break;
                            case 'b':
                                Integer opcionCompra=-1;
                                while(opcionCompra!=0){
                                    System.out.println("Selecciona un producto y salga con 0");
                                    Set<Stock> stocks=maquina.getStock();
                                    stocks.stream().forEach(e->System.out.println(e.getProducto().getMachineOption()+" "+e.getProducto().getName()+ " "+e.getProducto().getPrice()));
                                    opcionCompra= sc.nextInt();
                                    if(opcionCompra>0){
                                        maquina.comprar(opcionCompra);
                                    }
                                }

                                break;
                        }
                    }

                break;

                case 2:
                    Integer value=maquina.returnDineroCliente();
                    System.out.println("Valor retornado:"+value);
                break;

                case 3:
                    Set<Stock> stocknuevo=generateStockProductosAleatorio(productos);
                    maquina.maquinaReinicio(stocknuevo,150);
                break;

            }

            } catch (InputMismatchException e) {
                System.out.println("debes ingresar una opcion valida");
                sc.next();
            }

        }
    }

    private static Set<Stock> generateStockProductosAleatorio(List<Producto> productos) {
        Random aleatorio = new Random(System.currentTimeMillis());
        return productos.stream().map(e->new Stock(e,aleatorio.nextInt(100))).collect(Collectors.toSet());
    }

    private static List<Producto> generarProductos() {
        List<Producto> productos=new ArrayList<>();
        Producto coca=new Producto("Coca-cola",25,1);
        Producto pepsi=new Producto("Pepsi",35,2);
        Producto soda=new Producto("Soda",45,3);
        productos.add(coca);
        productos.add(pepsi);
        productos.add(soda);
        return productos;
    }
}
