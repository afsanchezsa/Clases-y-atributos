/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

/**
 *
 * @author USUARIO
 */
public class Detalle {
private int cantidadProducto;
private Producto producto;
    public Detalle(int cantidadProducto,Producto producto) {
        this.cantidadProducto = cantidadProducto;
        this.producto=producto;
    }
public double CalcularSubtotalVenta(){
double subtotal=0;
subtotal=this.producto.getCosto()*cantidadProducto;
return subtotal;

}
public double CalcularSubtotalCompra(){
double subtotal=0;
subtotal=this.producto.getPrecioVenta()*cantidadProducto;
return subtotal;

}

    public Producto getProducto() {
        return producto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

}
