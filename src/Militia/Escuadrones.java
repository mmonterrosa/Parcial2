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
public class Escuadrones implements Militia{
    
     //0=no, 1=recursos, 2=vehicuos, 3=Centro De Mando
    public int estadoAtacando =0;
    public int faseDeAtaque;
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
    public void Defender() {
    }

    @Override
    public int getFaseImplementacion() {
     return this.faseDeImplementacion;
    }
    
    @Override
    public String toString(){
        String estado= "No Esta Atacando";
        if(this.estadoAtacando==1)estado="Atacando Recursos";
        if(this.estadoAtacando==2)estado="Atacando Vehiculos";
        if(this.estadoAtacando==3)estado="Atacando Centro De Mando";
        return "Tipo: " + this.nombre + "\n" + "Vida: "+ this.vida + "\n" + "Damage: " + this.damage 
                + "\n" + "Fase de Implementacion: " + this.faseDeImplementacion 
                + "\n" + "Estado: " + estado;
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
    public int getDaseDeAtaque() {
      return this.faseDeAtaque;
    }

    @Override
    public void setFaseDeAtaque(int x) {
       this.faseDeAtaque= x;
    }

    @Override
    public int Atacar() {
    return damage;
    }
    
    
    
}
