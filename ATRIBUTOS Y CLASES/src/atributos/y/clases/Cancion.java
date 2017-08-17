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
public class Cancion {
    public String nombre="";
    public int precioindividual;
    public int duracionminutos;
    public int duracionsegundos;
    public int megabytes;
    public int calidadenkb;
    public Cancion(){
       nombre="";
     precioindividual=0;
     duracionminutos=0;
     duracionsegundos=0;
     megabytes=0;
     calidadenkb=0;
    }
    public Cancion(String nombre_, int precioindividual_,int duracionminutos_,int duracionsegundos_,int megabytes_,int calidadenkb_){
    nombre=nombre_;
    precioindividual=precioindividual_;
    duracionminutos=duracionminutos_;
    duracionsegundos=duracionsegundos_;
    megabytes=megabytes_;
    calidadenkb=calidadenkb_;
            
    }
}
