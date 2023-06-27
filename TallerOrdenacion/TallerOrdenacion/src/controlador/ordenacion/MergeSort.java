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
public class MergeSort<E extends Comparable<E>> {

    public void mergeSort(ListaEnlazada<E> lista) {
        
        if (lista.obtenerTamanio() <= 1) {
            return;
        }

        ListaEnlazada<E> listaIzquierda = new ListaEnlazada<>();
        ListaEnlazada<E> listaDerecha = new ListaEnlazada<>();
        int mitad = lista.obtenerTamanio() / 2;

        // Dividir la lista en dos
        for (int i = 0; i < mitad; i++) {
            listaIzquierda.insertar(lista.obtener(i));
        }

        for (int i = mitad; i < lista.obtenerTamanio(); i++) {
            listaDerecha.insertar(lista.obtener(i));
        }

        // Ordenar recursivamente las listas divididas
        mergeSort(listaIzquierda);
        mergeSort(listaDerecha);

        // Combinar las listas div ordenadas
        merge(listaIzquierda, listaDerecha, lista);
    }

    private void merge(ListaEnlazada<E> listaIzquierda, ListaEnlazada<E> listaDerecha, ListaEnlazada<E> lista) {
        int indiceIzquierda = 0;
        int indiceDerecha = 0;

        // Limpiar la lista original
        lista.vaciar();

        // Comparar y combinar elementos de las sublistas
        while (indiceIzquierda < listaIzquierda.obtenerTamanio() && indiceDerecha < listaDerecha.obtenerTamanio()) {
            E elementoIzquierda = listaIzquierda.obtener(indiceIzquierda);
            E elementoDerecha = listaDerecha.obtener(indiceDerecha);

            if (elementoIzquierda.compareTo(elementoDerecha) <= 0) {
                lista.insertar(elementoIzquierda);
                indiceIzquierda++;
            } else {
                lista.insertar(elementoDerecha);
                indiceDerecha++;
            }
        }

        // Agregar elementos restantes de la lista izquierda
        while (indiceIzquierda < listaIzquierda.obtenerTamanio()) {
            E elementoIzquierda = listaIzquierda.obtener(indiceIzquierda);
            lista.insertar(elementoIzquierda);
            indiceIzquierda++;
        }

        // Agregar elementos restantes de la lista derecha
        while (indiceDerecha < listaDerecha.obtenerTamanio()) {
            E elementoDerecha = listaDerecha.obtener(indiceDerecha);
            lista.insertar(elementoDerecha);
            indiceDerecha++;
        }
    }

    public void imprimir(ListaEnlazada<E> lista) {
        for (int i = 0; i < lista.obtenerTamanio(); i++) {
            System.out.print(lista.obtener(i) + " ");
        }
        System.out.println();
    }
}
