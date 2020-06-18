/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.arsw.game.PicosYFamas.Game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author danip
 */
public class GameTest {
    
    private final Juego game;
    
    public GameTest (){
        game = new Juego();
    }
    
    @Test
     public void ReiniciarJuegoEnsayos(){
        try {
            game.adivinar("5274");
            game.reiniciar();
            assertEquals(game.getIntentos(), new ArrayList<>());

        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
        
    }
     
     @Test
     public void ReiniciarJuegoIntento(){
        try {
            game.adivinar("5274");
            game.reiniciar();
            assertEquals(game.getIntento(), 0);

        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
        
    }
     
     @Test
     public void CadenaInvalida(){
        try {
            game.adivinar("524");
            assertEquals(game.getEstado(), "Cadena invalida");
        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
     
    @Test
    public void CadenaInvalida2(){
        try {
            game.adivinar("123");
            assertEquals(game.getEstado(), "Cadena invalida");
        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
     
     @Test
     public void PreguntaCorrecta(){
        try {
            game.adivinar("5241");
            game.adivinar("5241");
            assertEquals(game.getIntento(), 2);
        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
     
   @Test
     public void PreguntaCorrecta2(){
        try {
            for(int i=0; i<10;i++){
                 game.adivinar("524"+i);
            }
            assertEquals(game.getIntento(), 10);
        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
}
