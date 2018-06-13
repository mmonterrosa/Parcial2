/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import EntrenamientoMilitia.Entrenamiento;
import Militia.Escuadrones;
import Militia.Especialistas;
import Militia.Militia;
import Razas.Razas;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public class FactoryMilitia implements AbstractFactory {

    @Override
    public Razas getRazas(String type) {
      return null;
    }

    @Override
    public Militia getMilitia(String type) {
   return null;
    }

    @Override
    public EdifRecursos getEdifRecursos(int type, int espera) {
    return null;
    }

    @Override
    public Entrenamiento getEntrenamiento(String type) {
    return null;
    }

    @Override
    public Administrador getAdministrador(String type) {
    return null;
    }

    @Override
    public EdifVehiculos getVehiculo(int type, int espera) {
   return null;}

    @Override
    public Militia getMilitia(int type, int espera, int ataquePorFase) {
    switch(type){
        case 1:
            return new Escuadrones(espera,ataquePorFase);
        case 2:
            return Especialistas.getInstanced(espera, ataquePorFase);
                           
        } 
    return null;
    
    
    }
    
}
