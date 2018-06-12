/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Administrador.Administrador;
import EdificacionRecursos.EdifCobre;
import EdificacionRecursos.EdifRecursos;
import EntrenamientoMilitia.Entrenamiento;
import Militia.Militia;
import Razas.Razas;
import EdificacionRecursos.EdifOro;
import EdificacionRecursos.EdifPlata;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public class FactoryRecursos implements AbstractFactory{

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
        switch (type){
            case 1: 
                return new EdifOro(espera);
            case 2: 
                return new EdifPlata(espera);
            case 3: 
                return new EdifCobre(espera);
                           
        }
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
    return null;
    }
    
    
}
