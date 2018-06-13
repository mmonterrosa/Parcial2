/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Militia;

import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class Escuadrones implements Militia{
    public String nombre ="Escuadron";
    public int fasesEspera;
    public int faseDeImplementacion;
    public int damage;
    
    private int vida= 500;

    public Escuadrones() {
        
    }
    public Escuadrones(int fasesEspera, int damage){
        
        this.fasesEspera=fasesEspera;
        this.faseDeImplementacion=Menu.fase + fasesEspera;
        this.damage=damage;
    }
    
    

    @Override
    public void Atacar() {
    }

    @Override
    public void Defender() {
    }

    @Override
    public int getFaseImplementacion() {
     return this.faseDeImplementacion;
    }
    
    @Override
    public String toString(){
        return "Tipo: " + this.nombre + "\n" + "Vida: "+ this.vida + "\n" + "Damage: " + this.damage 
                + "\n" + "Fase de Implementacion: " + this.faseDeImplementacion + "\n";
    }
    
    
    
    
}
