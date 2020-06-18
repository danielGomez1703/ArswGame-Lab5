/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.arsw.game.PicosYFamas.Game;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author danip
 */
public class Juego {
   
    private String respuesta;
    private String estado;
    private int intento;
    private ArrayList<String> intentos;
    /**
     * creador del juego
     */
    public Juego() {
       intentos=new ArrayList<>();
       respuesta="";
       Integer num;
       Random r=new Random();
       for (int i=0;i<4;i++){
           num=r.nextInt(10);
           respuesta+= num.toString();
       }
       intento=0;
       estado ="inicio";
    }
    /**
     * reinicia los valores por defecto del juego
     */
    public void reiniciar(){
       intentos=new ArrayList<>();
       respuesta="";
       Integer num;
       Random r=new Random();
       for (int i=0;i<4;i++){
           num=r.nextInt(10);
           respuesta+= num.toString();
       }
       intento=0;
       estado ="inicio";
        
    }
    /**
     * metodo principal del juego el cual dice los picos y las famas
     * @param pregunta cadena a evaluar
     * @return muertos y heridos o picas y famas
     */
    public String adivinar(String pregunta){
        Integer muertos =0;
        Integer heridos=0;
        if (pregunta.equals(respuesta)){
            return "Felicidade a Ganado - " + respuesta;
        }
        for(int i=0;i<4;i++){
            if (respuesta.contains(pregunta.charAt(i)+"")){
                if(pregunta.charAt(i) == respuesta.charAt(i)){
                    muertos++;
                }else{
                  heridos++;
                }
            }
                    
        }   
        intento++;
        intentos.add(""+pregunta+"-"+muertos+heridos);
       return ""+muertos+heridos;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }
    
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String pregunta) {
        this.respuesta = pregunta;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getIntentos() {
        return intentos;
    }

    public void setIntentos(ArrayList<String> intentos) {
        this.intentos = intentos;
    }
    
    
}
