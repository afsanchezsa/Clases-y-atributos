/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author USUARIO
 */
public class Laboratorio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here;
        boolean permanecer = true;
        String nombre, siono;
        int nit, cantidad,numero;
        int opcion;
        int IdEmpleado, IdCliente, ultimafactcomp, ultimafactven;
        String NombreEmpleado, NombreCliente, RazonSocial;
        double Salario;
        
        Producto producto = null;
        Pedido pedido;
        Proveedor proveedor;
        Empleado empleado;

        double precioVenta;
        double costo;
        boolean existe = false, seguir = true;
        int dia, mes, ano, FormaPago, anovencimiento, mesvencimiento, diavencimiento, Codigo;
        Date FechaVencimiento, fecha;
        ArrayList<FacturaCompra> compras = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el nombre del supermercado");
        nombre = in.next();
        System.out.println("ingrese el nit ");
        nit = in.nextInt();

        Supermercado tienda = new Supermercado(nombre, nit);

        do {
            System.out.println("Bienvenido, seleccione una opcion:");
            System.out.println("1.registrar empleado");
            System.out.println("2.registrar un producto");
            System.out.println("3.Generar una factura de compra a partir de los pedidos");
            System.out.println("4.registrar una factura de venta");
            System.out.println("5.registrar un pedido");
            System.out.println("6.imprimir productos agotados");
            System.out.println("7. imprimir inventario");
            System.out.println("8. Lo mas Vendido ");
            System.out.println("9.generar nomina");
            System.out.println("inserte el numero de la opcion");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("inserte la identificacion del empleado ");
                    IdEmpleado = in.nextInt();
                    System.out.println("ingrese el nombre ");
                    NombreEmpleado = in.next();
                    System.out.println("ingrese el salario");
                    Salario = in.nextDouble();
                    empleado = new Empleado(IdEmpleado, NombreEmpleado, Salario);
                    tienda.getNomina().addEmpleado(empleado);
                    break;
                case 2:

                    System.out.println("cuantos productos de este tipo se van a insertar?");
                    cantidad = in.nextInt();
                    System.out.println("ingrese el nombre del producto");
                    nombre = in.next();
                    System.out.println("ingrese el Precio de Venta");
                    precioVenta = in.nextDouble();
                    System.out.println("Ingrese el costo del producto");
                    costo = in.nextInt();
                    System.out.println(" ingrese el dia de vencimiento");
                    dia = in.nextInt();
                    System.out.println("ingrese el mes de vencimiento");
                    mes = in.nextInt();
                    System.out.println("ingrese el año de vencimiento");
                    ano = in.nextInt();
                    FechaVencimiento = new Date(ano, mes, dia);
                    for (int i = 0; i < cantidad; i++) {
                        producto = new Producto(nombre, precioVenta, costo, FechaVencimiento);
                        tienda.getInventario().addProducto(producto);

                    }
                    break;
                case 3:
                    System.out.println("ingrese año");
                    ano = in.nextInt();
                    System.out.println("ingrese el mes ");
                    mes = in.nextInt();
                    System.out.println(" ingrese dia ");
                    dia = in.nextInt();
                    System.out.println("forma de pago ");
                    FormaPago = in.nextInt();
                    System.out.println("ingrese el nit del proveedor");
                    nit = in.nextInt();
                    System.out.println("ingrese la razon social del proveedor");
                    RazonSocial = in.next();
                    System.out.println("ingrese el año de vencimiento ");
                    anovencimiento = in.nextInt();
                    System.out.println("ingrese el mes de vencimiento ");
                    mesvencimiento = in.nextInt();
                    System.out.println("ingrese el dia de vencimiento");
                    diavencimiento = in.nextInt();
                    for (int i = 0; i < tienda.getProveedores().size(); i++) {
                        if (tienda.getProveedores().get(i).getNit() == nit) {
                            proveedor = tienda.getProveedores().get(i);
                            existe = true;
                            break;
                        } else {
                            existe = false;
                        }
                    }

                    if (!existe) {
                        proveedor = new Proveedor(nit, RazonSocial);
                        tienda.getProveedores().add(proveedor);
                    } else {
                        proveedor = null;
                    }

                    tienda.addFacturaCompra(ano, mes, dia, FormaPago, proveedor, anovencimiento, mesvencimiento, diavencimiento);
                    TreeMap<Integer, Pedido> ped = tienda.getPedidos();
                    compras = tienda.getFacturascompra();
                    ultimafactcomp = compras.size() - 1;
                    tienda.getFacturascompra().get(ultimafactcomp).addPedido(ped);
                    tienda.getFacturascompra().get(ultimafactcomp).llenarDetalle();
                    for (Detalle det : tienda.getFacturascompra().get(ultimafactcomp).getDetalles()) {
                        for (int i = 0; i < det.getCantidadProducto(); i++) {
                            tienda.getInventario().addProducto(det.getProducto());
                        }
                    }
                    tienda.borrarPedidos();
                    break;

                case 4:
                    System.out.println("ingrese dia");
                    dia = in.nextInt();
                    System.out.println("ingrese mes ");
                    mes = in.nextInt();
                    System.out.println("ingrese año");
                    ano = in.nextInt();
                    fecha = new Date(ano, mes, dia);
                    System.out.println("ingrese la identificacion del cliente ");
                    IdCliente = in.nextInt();
                    System.out.println(" ingrese el Nombre del Cliente ");
                    NombreCliente = in.next();
                    System.out.println(" ingrese 1 si la forma de pago es efectivo y 2 si es con tarjeta");
                    FormaPago = in.nextInt();
                    System.out.println("ingrese el año de vencimiento de la factura");
                    anovencimiento = in.nextInt();
                    System.out.println("ingrese el mes de vencimiento de la factura");
                    mesvencimiento = in.nextInt();
                    System.out.println("ingrese el dia de vencimiento de la factura");
                    diavencimiento = in.nextInt();
                    tienda.addFactura(fecha, IdCliente, NombreCliente, FormaPago, anovencimiento, mesvencimiento, diavencimiento);

                    ultimafactven = tienda.getFacturas().size() - 1;
                    do {
                        System.out.println("ingrese el nombre del producto");
                        nombre = in.next();
                        System.out.println("ingrese la cantidad");
                        cantidad = in.nextInt();
                        for (int j = 0; j < cantidad; j++) {
                            for (int i = 0; i < tienda.getInventario().getProductos().size(); i++) {

                                if (tienda.getInventario().getProductos().get(i).getNombre().equalsIgnoreCase(nombre)) {
                                    producto = tienda.getInventario().getProductos().get(i);
                                    tienda.getFacturas().get(ultimafactven).addDetalle(producto, 1);

                                    tienda.getInventario().getProductos().remove(i);

                                    break;
                                } else {

                                    System.out.println("el producto no ha sido registrado");
                                }

                            }
                        }

                        System.out.println("¿desea registrar otro detalle? presione Y en caso de querer registrar uno nuevo, u otra tecla en caso contrario");
                        siono = in.next();
                        if (siono.equalsIgnoreCase("y")) {
                            seguir = true;

                        } else {
                            seguir = false;

                        }
                    } while (seguir);

                    break;
                case 5:
                    System.out.println("Pedido:");
                    System.out.println("ingrese el Nombre del producto");
                    nombre = in.next();
                    existe = false;
//cantidad=tienda.getInventario().ContarProducto(nombre);
                    for (Producto p : tienda.getInventario().getProductos()) {
                        if (p.getNombre().equalsIgnoreCase(nombre)) {
                            existe = true;
                            producto = p;
                            System.out.println("ingrese la cantidad del producto ");
                            cantidad = in.nextInt();
                            tienda.addPedido(producto, cantidad);
                            break;
                        }

                    }
                    if (!existe) {
                        System.out.println("no se ha registrado el producto en el inventario");
                    }

                    break;
                case 6:
                    System.out.println("Los Productos agotados(con disponibilidad de menos de 3 unidades) son: ");
                    for (String agotado : tienda.agotados()) {
                        System.out.println(agotado);
                    }

                    break;
                case 7:
                    System.out.println("Producto \t\t  cantidad");
                    ArrayList<String >sinrepetir=new ArrayList<>();
                           
                    for(int i=0;i<tienda.getInventario().productos.size();i++){
                        if(!existe(tienda.getInventario().productos.get(i).getNombre(), sinrepetir))
                     sinrepetir.add(tienda.getInventario().productos.get(i).getNombre());
//  System.out.println(sinrepetir.get(i)+" "+tienda.getInventario().ContarProducto(sinrepetir.get(i)));
                    }
                    for(String cadena:sinrepetir){
                        System.out.println(cadena+"\t\t"+tienda.getInventario().ContarProducto(cadena));
                    }
                    break;
                case 8:
                    System.out.println("producto\t cantidad vendida");
                    for(Entry<String,Integer>entry:tienda.lomascomprado().entrySet()){
                     nombre=entry.getKey();
                     numero=entry.getValue();
                        System.out.println(nombre+"           "+numero);
                        
                    
                    
                        
                    }
                    break;
                    case 9:
                    System.out.println("\t\t\tNomina");
                        System.out.println("desea configurar los dias trabajados de algun empleado y/other?");
                        siono=in.next();
                        if(siono.equalsIgnoreCase("y")){
                        seguir=true;
                        }else{
                        seguir=false;
                        }
                        ArrayList<Integer> idsempleados=new ArrayList<>();
                    while(seguir){
                        System.out.println("inserte la identificacion del empleado al que desea configurar sus dias trabajados");
                          IdEmpleado=in.nextInt();
                          System.out.println("ingrese el numero de dias trabajados");
                          dia=in.nextInt();
                          tienda.getNomina().empleados.get(IdEmpleado).SetDiasTrabajados(dia);
                          idsempleados.add(IdEmpleado);
                    }    
                    System.out.println("Cedula \t\t Empleado\t Salario\tSueldo a Pagar\tAbono a Liquidacion");
                        
                        for(Entry<Integer,Empleado>entrada:tienda.getNomina().empleados.entrySet()){
                        numero=entrada.getKey();
                        empleado=entrada.getValue();
                            System.out.println(empleado.getIdEmpleado()+"  "+empleado.getNombreEmpleado()+" "+empleado.getSalario()+" "+empleado.CalcularSueldo(numero)+""+
                            tienda.getNomina().LiquidacionEmpleado(numero)/12);
                        }
                        for(int i=0;i<idsempleados.size();i++){
                        tienda.getNomina().empleados.get(idsempleados.get(i)).SetDiasTrabajados(30);
                        }
                        break;
                    case 10:
                        System.out.println("valor a pagar a los proveedores:");
                        for(FacturaCompra f:tienda.getFacturascompra()){
                            System.out.println("Nit\tProveedor\t valorFactura");
                            if(f.getCancelada()==false){
                            System.out.println(f.getIdProveedor()+"  "+f.getNombreProveedor()+"  "+f.getTotalFactura());
                        }
                        }break;
                    case 11:
                        System.out.println("Numero \t valor \t Fecha de Vencimiento\t Proveedor");
                    for(FacturaCompra f:tienda.getFacturascompra()){
                    if(diferenciafechas(new Date(), f.getFechaVencimiento())<10){
                    System.out.println(f.getNumero()+" "+f.getTotalFactura()+" "f.getFechaVencimiento().getDay()+"/"+f.getFechaVencimiento().getMonth()+"/"+f.getFechaVencimiento().getYear()+" "+f.getNombreProveedor());
                    }
                    }    
            }
            

        } while (permanecer);

    }
public static boolean existe(String nombre,ArrayList<String>arreglo){

    for(String s:arreglo){
if(nombre.equalsIgnoreCase(s)){
return true;
}
}
return false;
}
public static int  diferenciafechas(Date fecha1,Date fecha2){

long fec1=fecha1.getTime();
long fec2=fecha2.getTime();
long diferencia=fec2-fec1;
return (int)diferencia;
}
}
