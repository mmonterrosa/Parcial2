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
public class EdifPlata implements EdifRecursos{
    public int lootPorFase=100;
    public int vida = 500;
    public String nombre = "Edificacion de Plata";
    public int fasesEspera;
    public int faseAImplementar;
    

    public EdifPlata() {
    }

    
    
    public EdifPlata(int espera) {
        this.fasesEspera = espera;
        this.faseAImplementar = Menu.fase + fasesEspera;
                
    }
    
    @Override
    public int recolectar() {
    return lootPorFase;
            }

    @Override
    public int getVida() {
    return vida;
    }
    
    @Override
    public String toString() {
        return "\nTipo de Edificacion: "+ nombre + "\nVida: " + vida;
   
    }

    @Override
    public int getFaseImplementacion() {
    return faseAImplementar;
    }

    @Override
    public String getNombre() {
    return nombre;
    }
    
     @Override
    public void setVida(int x) {
    this.vida=x;
    }
}
