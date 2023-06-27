/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wilman
 */
public class ModeloTabla extends AbstractTableModel {

    ListaEnlazada<Integer> lista = new ListaEnlazada<>();

    public void addRow(Integer elemento) {
        if (lista != null) {
            lista.insertar(elemento);
            fireTableDataChanged();
        }
    }

    /**
     * Elimina la fila en el índice especificado de la tabla.
     *
     * @param rowIndex El índice de la fila a eliminar.
     */
    public void removeRow(int rowIndex) {
        if (lista != null) {
            lista.eliminar(rowIndex);
            fireTableDataChanged();
        }
    }

    public ListaEnlazada<Integer> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Integer> lista) {
        this.lista = lista;
    }

    public void setRowCount(int rowCount) {
        int currentRowCount = lista.getSize();

        // Si el nuevo número de filas es menor, eliminamos las filas adicionales
        if (rowCount < currentRowCount) {
            for (int i = currentRowCount - 1; i >= rowCount; i--) {
                try {
                    lista.eliminar(i);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        } // Si el nuevo número de filas es mayor, agregamos filas vacías adicionales
        else if (rowCount > currentRowCount) {
            for (int i = currentRowCount; i < rowCount; i++) {
                lista.insertar(null);
            }
        }

        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Integer it = null;
        try {
            it = lista.get(rowIndex);
        } catch (Exception e) {

        }
        switch (columnIndex) {
            case 0:
                return it;

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Numeros";
            default:
                return null;
        }

    }

}
