/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo.tabla;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import javax.swing.table.AbstractTableModel;
import modelo.Simulacion;

/**
 *
 * @author romer
 */
public class ModeloTabla extends AbstractTableModel {
    private DynamicList<Simulacion> simulaciones;

    @Override
    public int getRowCount() {
        return simulaciones.getLenght();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Simulacion simulacion = simulaciones.getInfo(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    return (simulacion != null)? simulacion.getNumPersonas() : "";
                case 1:
                    return (simulacion != null)? simulacion.getTiempoTotal(): "";
                default:
                    return null;
            }
        } catch (EmptyException ex) {
            return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Numero de Personas";
            case 1:
                return "Tiempo";
            default:
                return null;
        }
    }

    public DynamicList<Simulacion> getSimulaciones() {
        return simulaciones;
    }

    public void setSimulaciones(DynamicList<Simulacion> simulaciones) {
        this.simulaciones = simulaciones;
    }
    
    
    
}
