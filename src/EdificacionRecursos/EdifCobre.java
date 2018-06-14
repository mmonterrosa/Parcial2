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
public class EdifCobre implements EdifRecursos{
    public int lootPorFase=150;
    public int vida = 500;
    public String nombre = "Edificacion de Cobre";
    public int fasesEspera;
    public int faseAImplementar;

    public EdifCobre() {
    }

    public EdifCobre(int espera) {
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

    public void setFasesEspera(int fasesEspera) {
        this.fasesEspera = fasesEspera;
    }

    public void setFaseAImplementar(int faseAImplementar) {
        this.faseAImplementar = faseAImplementar;
    }

    @Override
    public int getFaseImplementacion() {
       return faseAImplementar;
     }

    @Override
    public String getNombre() {
    return this.nombre; 
    }

    @Override
    public void setVida(int x) {
    this.vida=x;
    }
    
    
    
}
