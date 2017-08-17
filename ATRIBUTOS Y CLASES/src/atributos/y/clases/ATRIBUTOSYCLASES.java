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
public class ATRIBUTOSYCLASES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String artista="",nombredisco="",nombrecancion="",genero="",imagen="",name="";
       boolean permanecer=true;
        Disco []discoss=new Disco[5];
        for(int i=0;i<5;i++){
        discoss[i]=new Disco();
        }
        int contador,opcion,precioindividual,minutos,segundos,megabytes,calidad;
        for( contador=0;contador<5;contador++){
        discoss[contador]=new Disco();
        }
        Scanner entrada=new Scanner(System.in);
        contador=0;
        while(permanecer){
            System.out.println("seleccione una opcion: ");
            System.out.println("1. CONSULTAR CANCION \n 2.AGREGAR UN DISCO AL CATALOGO \n 3.AGREGAR UNA CANCION AL DISCO");
        opcion=entrada.nextInt();
        switch(opcion){
            case 1:
                System.out.println("inserte el nombre del disco");
                nombredisco=entrada.next();
                System.out.println("inserte el nombre de la cancion");
                nombrecancion=entrada.next();
                for(int i=0;i<5;i++){
                if(discoss[i].nombre.equalsIgnoreCase(nombredisco)){
                discoss[i].consultarcancion(nombrecancion);
                }
                }
                break;
                               
           case 2:
                System.out.println("inserte el nombre del disco");
                nombredisco=entrada.next();
                //discoss[contador].nombre=nombredisco;
                System.out.println("inserte el nombre del artista");
                artista=entrada.next();
              //  discoss[contador].artista=artista;
                System.out.println("inserte el genero del disco");
                genero=entrada.next();
                //discoss[contador].genero=genero;
                System.out.println("inserte direccion de la imagen");
                imagen=entrada.next();
                //discoss[contador].imagen=imagen;
                discoss[contador]=new Disco(nombredisco, artista, genero, imagen);
                contador++;
                break;
           case 3:
               System.out.println("inserte el nombre del disco");
               nombredisco=entrada.next();
              for( int i=0;i<4;i++){
              if(discoss[i].nombre.equalsIgnoreCase(nombredisco)){
              precioindividual=0;
              minutos=0;
              segundos=0;
              megabytes=0;
              calidad=0;
                  System.out.println("inserte nombre de la cancion");
                  name=entrada.next();
                  System.out.println("inserte precio de la cancion");
                  precioindividual=entrada.nextInt();
                  System.out.println("inserte duracion en minutos");
                  minutos=entrada.nextInt();
                  System.out.println("inserte duracion en segundos");
                  segundos=entrada.nextInt();
                  System.out.println("inserte megabytes de la cancion");
                  megabytes=entrada.nextInt();
                  System.out.println("inserte kb de calidad");
                 calidad=entrada.nextInt();
                 
                 for(int n=0;n<5;n++){
                 if(discoss[i].canciones[n].nombre.equalsIgnoreCase("")){
                 discoss[i].canciones[n]=new Cancion(name,precioindividual,minutos, segundos, megabytes, calidad);
                 }
                 }
                 
              }
              }
               
                
                
        }
        int comodin;
            System.out.println("desea continuar?(1/0)");
            comodin=entrada.nextInt();
            if(comodin==0){
            permanecer=false;
            }
        }
       
        
        
    }
    
}
