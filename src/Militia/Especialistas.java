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
public class Especialistas implements Militia{
    private static Especialistas instance; //Singleton
    
    public String nombre = "Especialista";
    public int fasesEspera;
    public int faseDeImplementacion;
    public int damage;
    public int vida=500;
    

    @Override
    public void Atacar() {
    }

    @Override
    public void Defender() {
    
    }
    
    private Especialistas(){  
    }
    private Especialistas(int espera, int damage){
        this.fasesEspera = espera;
       this.faseDeImplementacion=Menu.fase + espera;
        this.damage = damage;
    }
    
    public synchronized static Especialistas getInstanced(){
        if (instance == null){
            instance = new Especialistas();
        }
        return instance;
        
        
    }
     public synchronized static Especialistas getInstanced(int espera, int damage){
        if (instance == null){
            instance = new Especialistas(espera, damage);
        }
        return instance;
        
        
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
