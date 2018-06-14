/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Militia;

import CentroDeMando.CentroDeMando;
import EdificacionRecursos.EdifRecursos;
import Vehiculos.EdifVehiculos;
import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class Especialistas implements Militia{
    private static Especialistas instance; //Singleton
    
    //0=no, 1=recursos, 2=vehicuos
    public int estadoAtacando =0;
    public int faseDeAtaque;
    public String nombre = "Especialista";
    public int fasesEspera;
    public int faseDeImplementacion;
    public int damage;
    public int vida=500;
    

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

    @Override
    public String getNombre() {
    return this.nombre;
            }

    @Override
    public int getEstadoAtacando() {
     return this.estadoAtacando;
    }

    @Override
    public void setEstadoAtacando(int x) {
    this.estadoAtacando=x;
    }

 
     @Override
    public int Atacar() {
    return damage;
    }

      @Override
    public int getDaseDeAtaque() {
      return this.faseDeAtaque;
    }

    @Override
    public void setFaseDeAtaque(int x) {
       this.faseDeAtaque= x;
    }
    
}
