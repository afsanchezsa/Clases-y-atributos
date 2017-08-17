/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos.y.clases;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Cuentabancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int contrasena=0,nueva=0;
    Cuenta MagdalenaSanchez=new Cuenta();
    MagdalenaSanchez.numero=1012;
      MagdalenaSanchez.clavedeacceso=1234;
      MagdalenaSanchez.Saldo=0;
      MagdalenaSanchez.consignardinero(100000);
      Cuenta JoselitoPerez=new Cuenta();
      JoselitoPerez.numero=1013;
      JoselitoPerez.clavedeacceso=9876;
      
      JoselitoPerez.Saldo=500000;
        System.out.println("inserte la contraseña actual");
        Scanner entrada=new Scanner(System.in);
        contrasena=entrada.nextInt();
        System.out.println("inserte la nueva contraseña");
        nueva=entrada.nextInt();
        JoselitoPerez.cambiarclave(contrasena, nueva);
        JoselitoPerez.consultarsaldo();
                  }
    
}
