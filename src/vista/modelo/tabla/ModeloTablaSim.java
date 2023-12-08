/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo.tabla;

import controlador.TDA.colas.QueueUltimate;
import controlador.TDA.listas.Exception.EmptyException;
import javax.swing.table.AbstractTableModel;
import modelo.Tramite;

/**
 *
 * @author romer
 */
public class ModeloTablaSim extends AbstractTableModel{
    private QueueUltimate<Tramite> ventanillas;

    @Override
    public int getRowCount() {
        return ventanillas.lenght();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Tramite tramite = ventanillas.getData(rowIndex);
            switch (columnIndex){
                case 0:
                    return (tramite != null) ? tramite.getId() 
                            + ", Nombre: " +  tramite.getNombre() 
                            + ", Duracion: " + tramite.getDuracion(): "";
                default:
                    return null;
            }
        } catch (EmptyException ex) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Detalle Ventanilla";
            default:
                return null;
        }
    }

    public QueueUltimate<Tramite> getVentanillas() {
        return ventanillas;
    }

    public void setVentanillas(QueueUltimate<Tramite> ventanillas) {
        this.ventanillas = ventanillas;
    }
}
