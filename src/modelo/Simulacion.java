/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.TDA.colas.QueueUltimate;
import controlador.TDA.listas.DynamicList;

/**
 *
 * @author romer
 */

public class Simulacion {
    private Integer id;
    private Integer numPersonas;
    private Integer tiempoTotal;
    private DynamicList<QueueUltimate<Tramite>> ventanillas = new DynamicList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public DynamicList<QueueUltimate<Tramite>> getVentanillas() {
        return ventanillas;
    }

    public void setVentanillas(DynamicList<QueueUltimate<Tramite>> ventanillas) {
        this.ventanillas = ventanillas;
    }
}
