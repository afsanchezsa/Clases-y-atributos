/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos.y.clases;

/**
 *
 * @author USUARIO
 */
public class Cuenta {
    public int numero;
    public int clavedeacceso;
    public String dueno;
    public double Saldo ;
public void consignardinero(int monto){
this.Saldo=this.Saldo+monto;
}
    public void retirardinero(int monto){
   this.Saldo=this.Saldo-monto;
    }
    public  void cambiarclave(int claveanterior,int clavenueva){
    if(claveanterior==this.clavedeacceso){
    this.clavedeacceso=clavenueva;
        System.out.println("se ha cambiado la clave de acceso");
    }else{
        System.out.println("no se pudo realizar el cambio de claveya que la contraseña actual no coincide");
    }
    }
    public void consultarsaldo(){
        System.out.println(" el saldo en cuenta es "+this.Saldo);
    }
}
