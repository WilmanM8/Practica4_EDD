/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallerordenacion;

import controlador.ed.lista.ListaEnlazada;
import controlador.ordenacion.MergeSort;
import controlador.ordenacion.QuickSort;

/**
 *
 * @author wilman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Integer ASCENDENTE = 0;
    public static Integer DESCENDENTE = 1;

    public static void main(String[] args) {

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        

        Integer size = 10;
        ListaEnlazada<Integer> m = new ListaEnlazada<>();
        ListaEnlazada<Integer> n = new ListaEnlazada<>();
        ListaEnlazada<Integer> matriz = new ListaEnlazada<>();
        ListaEnlazada<Integer> matriz1 = new ListaEnlazada<>();

        for (int i = 0; i < size; i++) {
            m.insertar((int) (Math.random() * 100));
            n.insertar((int) (Math.random() * 100));
            matriz.insertar(i);
            matriz1.insertar(i);
        }

        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();

        // Ordenar lista m con MergeSort
        mergeSort.mergeSort(m);
        System.out.println("Lista m ordenada con MergeSort:");
        mergeSort.imprimir(m);

        // Ordenar lista n con QuickSort
        quickSort.quicksortRecursivo(n);
        System.out.println("Lista n ordenada con QuickSort:");
        quickSort.imprimir(n);

        

    }
}
