/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdificacionRecursos;

import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class EdifOro implements EdifRecursos{
        public int vida = 500;
        public String nombre = "Edificacion de Oro";
        public int fasesEspera;
        public int faseAImplementar;

    public EdifOro() {
    }

    public EdifOro(int espera) {
        this.fasesEspera = espera;
        this.faseAImplementar = Menu.fase + fasesEspera;
    }
    
    
    
    @Override
    public int recolectar() {
    return 50;
    }

    @Override
    public int getVida() {
    return vida;
    }
    
    @Override
    public String toString() {
        return "Tipo de Edificacion: "+ nombre + " Vida: " + vida;
   
    }

    @Override
    public int getFaseImplementacion() {
     return faseAImplementar;
    }
    
}
