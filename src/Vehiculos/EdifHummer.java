/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class EdifHummer implements EdifVehiculos{
    
        public String nombre = "Hummer";
        public int vida = 500;
        public int fasesEspera;
        public int faseAImplementar;

    public EdifHummer() {
    }

    public EdifHummer(int fasesEspera) {
        this.fasesEspera = fasesEspera;
        this.faseAImplementar = Menu.fase + fasesEspera;
    }

    @Override
    public int getFaseImplementacion() {
     return this.faseAImplementar;
    }
    @Override
    public String toString() {
        return "\nTipo de Edificacion: "+ nombre + "\nVida: " + vida;
   
    }

    @Override
    public String getNombre() {
    return this.nombre;
    }
        
        
}
