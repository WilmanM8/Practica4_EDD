/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author wilman
 */
public class QuickSort<E extends Comparable<E>> {

    public void quicksortRecursivo(ListaEnlazada<E> lista) {
        
        quicksortRecursivo(lista, 0, lista.getSize() - 1);
    }

    private void quicksortRecursivo(ListaEnlazada<E> lista, int indiceInicio, int indiceFin) {
        if (indiceInicio < indiceFin) {
            int indiceParticion = particion(lista, indiceInicio, indiceFin);
            quicksortRecursivo(lista, indiceInicio, indiceParticion - 1);
            quicksortRecursivo(lista, indiceParticion + 1, indiceFin);
        }
    }

    private int particion(ListaEnlazada<E> lista, int indiceInicio, int indiceFin) {
        E pivote = lista.obtener(indiceFin);
        int indicePivote = indiceInicio;

        for (int i = indiceInicio; i < indiceFin; i++) {
            if (lista.obtener(i).compareTo(pivote) <= 0) {
                lista.intercambiar(i, indicePivote);
                indicePivote++;
            }
        }

        lista.intercambiar(indicePivote, indiceFin);

        return indicePivote;
    }

    public void imprimir(ListaEnlazada<E> lista) {
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.print(lista.obtener(i) + " ");
        }
        System.out.println();
    }
}
