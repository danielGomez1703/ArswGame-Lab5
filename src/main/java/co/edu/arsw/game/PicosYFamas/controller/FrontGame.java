/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.arsw.game.PicosYFamas.controller;

import co.edu.arsw.game.PicosYFamas.Game.Juego;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author danip
 */

@Controller
public class FrontGame {
    

    private Juego game=new Juego();;
    private ArrayList<String> intentos =new ArrayList<>();
    private String respuesta="";

        
    public static void main(String[] args) {
        SpringApplication.run(FrontGame.class, args);
    }
    
    @GetMapping("/")
    public String openGame(Model model) {
        
        model.addAttribute("intento", game.getIntento());
        model.addAttribute("estado", game.getEstado());
        model.addAttribute("respuesta", respuesta);
        model.addAttribute("listIntentos", game.getIntentos());
        return "Principal";
    }
    
    @RequestMapping(value = "/", method=RequestMethod.POST, params={"guess"}) 
    public String adivinar(String cadena){
        respuesta=game.adivinar(cadena);
        intentos.add(respuesta);
        return"redirect:/";
    }
    @RequestMapping(value = "/", method=RequestMethod.POST, params={"reset"}) 
    public String resetGame(){
        game.reiniciar();
        return"redirect:/";
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    @ModelAttribute("allTries")
    public List<String> getIntentos() {
        return intentos;
    }
    
    public void setIntentos(ArrayList<String> intentos) {
        this.intentos = intentos;
    }
    
    
    public Juego getGame() {
        return game;
    }

    public void setGame(Juego game) {
        this.game = game;
    }
    
 /**   @RequestMapping(value = "/processForm", method=RequestMethod.POST, params={"save"}) 
public String processForm(@ModelAttribute(value="foo") Foo foo) { 
    ... */


}
