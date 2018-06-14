/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Militia;

import CentroDeMando.CentroDeMando;
import EdificacionRecursos.EdifRecursos;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public interface Militia {
    public int Atacar();
    public void Defender();
    public int getFaseImplementacion();
    public String getNombre();
    public int getEstadoAtacando();
    public void setEstadoAtacando(int x);
    public int getDaseDeAtaque();
    public void setFaseDeAtaque(int x);
}
