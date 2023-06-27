/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;

/**
 *
 * @author wilman
 */
public class ListaEnlazada<E extends Comparable<E>> {

    private Nodo<E> primerNodo;
    private Nodo<E> ultimoNodo;
    private Integer size;

    public void vaciar() {
        primerNodo = null;
        size = 0;
    }

    public E eliminar(int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        E elemento;

        if (indice == 0) {
            elemento = primerNodo.getDato();
            primerNodo = primerNodo.getSiguiente();
        } else {
            Nodo<E> nodoAnterior = obtenerNodo(indice - 1);
            Nodo<E> nodoActual = nodoAnterior.getSiguiente();
            elemento = nodoActual.getDato();
            nodoAnterior.setSiguiente(nodoActual.getSiguiente());
        }

        size--;
        return elemento;
    }

    public Nodo<E> getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo<E> primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo<E> getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo<E> ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer size() {
        return size;
    }

    public ListaEnlazada() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }

    public ListaEnlazada<E> clonar() {
        ListaEnlazada<E> nuevaLista = new ListaEnlazada<>();
        Nodo<E> actual = primerNodo;

        while (actual != null) {
            nuevaLista.insertar(actual.getDato());
            actual = actual.getSiguiente();
        }

        return nuevaLista;
    }

    public void reemplazar(int indice, E elemento) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo<E> actual = obtenerNodo(indice);
        actual.setDato(elemento);
    }

    public void insertar(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }

        size++;
    }

    public E obtener(int indice) {
        validarIndice(indice);

        Nodo<E> nodoActual = primerNodo;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }

        return nodoActual.getDato();
    }

    public void intercambiar(int indice1, int indice2) {
        validarIndice(indice1);
        validarIndice(indice2);

        if (indice1 == indice2) {
            return;
        }

        int indiceMenor = Math.min(indice1, indice2);
        int indiceMayor = Math.max(indice1, indice2);

        Nodo<E> nodoMenor = obtenerNodo(indiceMenor);
        Nodo<E> nodoMayor = obtenerNodo(indiceMayor);

        E temp = nodoMenor.getDato();
        nodoMenor.setDato(nodoMayor.getDato());
        nodoMayor.setDato(temp);
    }

    public int obtenerTamanio() {
        return size;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    private Nodo<E> obtenerNodo(int indice) {
        validarIndice(indice);

        Nodo<E> nodoActual = primerNodo;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }

        return nodoActual;
    }

    public boolean isEmpty() {
        return primerNodo == null;
    }

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = primerNodo.getDato();
                } else {
                    Nodo<E> aux = primerNodo;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public void insertarAlInicio(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primerNodo);
            primerNodo = nuevoNodo;
        }

        size++;
    }
}
