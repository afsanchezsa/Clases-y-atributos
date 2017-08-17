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
public class Disco {
    public String nombre;
    public String artista;
    public String genero;
    public String imagen;
    Cancion[]canciones=new Cancion[4];
    public Disco(){
for(int i=0;i<4;i++){
canciones[i]=new Cancion();
        }
        
}
    public Disco(String nombre_,String artista_,String genero_,String imagen_){
       nombre=nombre_;
     artista=artista_;
     genero=genero_;
     imagen=imagen_;
    }
  public void insertarcancion(String name,int precio,int minutos,int segundos,int megabytes,int calidad){
for(int i=0;i<4;i++){
      if(this.canciones[i].nombre==""){
this.canciones[i].nombre=name;
this.canciones[i].precioindividual=precio;
this.canciones[i].duracionminutos=minutos;
this.canciones[i].duracionsegundos=segundos;
this.canciones[i].megabytes=megabytes;
this.canciones[i].calidadenkb=calidad;
}
}
  }
  public void consultarcancion(String nombrecancion){
      for(int i=0;i<4;i++){
      if(this.canciones[i].nombre.equalsIgnoreCase(nombrecancion)){
          System.out.println("nombre "+this.canciones[i].nombre);
          System.out.println("precio individual "+this.canciones[i].precioindividual);
          System.out.println("duracion en segundos "+this.canciones[i].duracionsegundos);
          System.out.println("duracion en minutos "+this.canciones[i].duracionminutos);
          System.out.println("megabytes: "+this.canciones[i].megabytes);
          System.out.println("calidad: "+this.canciones[i].calidadenkb +"kilobytes");
      }
      }
  }
}
