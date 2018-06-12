/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import EntrenamientoMilitia.Entrenamiento;
import Militia.Militia;
import Razas.Razas;
import Vehiculos.EdifConvoy;
import Vehiculos.EdifHummer;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public class FactoryVehiculo implements AbstractFactory{

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
    switch(type){
        case 1:
            return new EdifConvoy(espera);
        case 2:
            return new EdifHummer(espera);
            
            
        }
    return null;
    }
    
}
