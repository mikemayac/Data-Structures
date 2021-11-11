package fciencias.edatos.proyecto01;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Práctica 2 del curso de Estructuras de Datos.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
* @version 17 Octubre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/

public class DoubleLinkedList<T> implements TDAList<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El e del nodo. */
        public T e;
        /* El nodo anterior. */
        public Nodo anterior;
        /* El nodo siguiente. */
        public Nodo siguiente;

        /* Construye un nodo con un e. */
        public Nodo(T e) {
          this.e = e;

        }
    }

    /* Clase interna privada para iteradores. */
    private class Iterador implements IteradorList<T> {
        /* El nodo anterior. */
        public Nodo anterior;
        /* El nodo siguiente. */
        public Nodo siguiente;

        /* Construye un nuevo iterador. */
        public Iterador() {
          siguiente  = cabeza;
          anterior = null;
        }

        /* Nos dice si hay un e siguiente. */
        @Override public boolean hasNext() {
            return siguiente != null;
          }

        /* Nos da el e siguiente. */
        @Override public T next() {
            if(siguiente == null){
              throw new NoSuchElementException("Sin e");
                }
                anterior = siguiente;
                siguiente = siguiente.siguiente;
                return anterior.e;
            }
        /* Nos dice si hay un e anterior. */
        @Override public boolean hasPrevious(){
            return anterior != null;
           }

        /* Nos da el e anterior. */
        @Override public T previous() {
            if(anterior == null){
              throw new NoSuchElementException("Sin e");
              }
              siguiente = anterior;
              anterior = anterior.anterior;
              return siguiente.e;
            }

        /* Mueve el iterador al inicio de la lista. */
        @Override public void start() {
            siguiente  = cabeza;
            anterior = null;
          }

        /* Mueve el iterador al final de la lista. */
        @Override public void end() {
            siguiente  = null;
            anterior = rabo;
        }
    }
    /* Primer e de la lista. */
    private Nodo cabeza;
    /* Último e de la lista. */
    private Nodo rabo;
    /* Número de es en la lista. */
    private int longitud;

    /**
     * Agrega un e al final de la lista. Si la lista no tiene es,
     * el e a agregar será el primero y último.
     * @param e el e a agregar.
     * @throws IllegalArgumentException si <code>e</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T e) {
      if(e == null){
        throw new IllegalArgumentException("e Invalido");
      }
      Nodo n = new Nodo(e);
      if(isEmpty()){
        cabeza = rabo = n;
      }
      else{
        rabo.siguiente = n;
        n.anterior = rabo;
        rabo = n;
      }
      longitud ++;
    }

    /**
     * Agrega un e al inicio de la lista. Si la lista no tiene es,
     * el e a agregar será el primero y último.
     * @param e el e a agregar.
      * @throws IllegalArgumentException si <code>e</code> es
     * <code>null</code>.
     */
    public void agregaInicio(T e) {
      if(e == null){
        throw new IllegalArgumentException("e Invalido");
      }
      Nodo n = new Nodo(e);
      if(isEmpty()){
        cabeza = rabo = n;
      }
      else{
       cabeza.anterior = n;
       n.siguiente = cabeza;
       cabeza = n;
      }
      longitud ++;
    }
    /**
    * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
    * @param i la posición donde agregar el elemento.
    * @param e el elemento a insertar.
    * @throws IllegalArgumentException  si <code>e</code> es
    * <code>null</code>.
    */
    public void add(int i, T e){
      if(e == null){
        throw new IllegalArgumentException("elemento Incorrecto");
      }
      if(isEmpty()){
        Nodo n = new Nodo(e);
        cabeza=rabo=n;
        longitud ++;
      }else if(i<=0){
        agregaInicio(e);
      }else if(i>=longitud){
        agregaFinal(e);
      }else{
        Nodo n = new Nodo(e);
        int f = 0;
        Nodo aux = cabeza;
      while(f<i){
        f++;
        aux = aux.siguiente;
      }if(aux != null){
         aux.anterior.siguiente = n;
         n.anterior = aux.anterior;
         n.siguiente = aux;
         aux.anterior = n;
      }longitud ++;
     }
    }
    /**
    * Limpia la lista. Elimina todos los elementos.
    */
    public void clear(){
      cabeza = rabo = null;
      longitud = 0;
    }

    /**
     * Metodo para buscar nodos
     * @return el nodo buscado
     */
    private Nodo buscaNodo(Nodo n, T e){
      if(n == null){
        return null;
      }
      if(n.e.equals(e)){
        return n;
      }
      return buscaNodo(n.siguiente, e);
    }

    /**
    * Verifica si un elemento está contenido en la lista.
    * @param e el elemento a verificar si está contenido.
    * @return true si el elemento está contenido, false en otro caso.
    */
    public boolean contains(T e){
      Nodo n = buscaNodo(cabeza, e);
      if(n == null){
        return false;
      }
      return true;
    }

    /**
    * Obtiene el elemento en la posición <i>i</i>.
    * @param i el índice a obtener elemento.
    * @throws IndexOutOfBoundException si el índice está fuera de rango.
    */
    public T get(int i) throws IndexOutOfBoundsException{
      if(i < 0 || i >= longitud){
        throw new ExcepcionIndiceInvalido("Indice Invalido");
      }
      int f = 0;
      Nodo aux = cabeza;
      while(f<i){
        f++;
        aux = aux.siguiente;
      }
      return aux.e;
    }

    /**
    * Verifica si la lista está vacía.
    * @return true si la lista no contiene elementos, false en otro caso.
    */
    public boolean isEmpty(){
      return cabeza == null;
    }

    /**
     * Elimina el primer e de la lista y lo regresa.
     * @return el primer e de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
      if(isEmpty()){
        throw new NoSuchElementException("Lista vacia");
      }
      T e = cabeza.e;
      if(cabeza == rabo){
         cabeza = rabo = null;
      }else{
        cabeza = cabeza.siguiente;
        cabeza.anterior = null;
      }
      longitud --;
      return e;
    }

    /**
     * Elimina el último e de la lista y lo regresa.
     * @return el último e de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
      if(isEmpty()){
        throw  new NoSuchElementException("Lista vacia");
      }
      T e = rabo.e;
      if(rabo == cabeza){
        rabo = cabeza = null;
      }else{
        rabo = rabo.anterior;
        rabo.siguiente = null;
      }
      longitud --;
      return e;
    }

    /**
    * Elimina el elemento en la posición <i>i</i>.
    * @param i el índice del elemento a eliminar.
    * @return el elemento eliminado.
    * @throws ExcepcionIndiceInvalido si el índice está fuera de rango.
    */
    public T remove(int i) throws ExcepcionIndiceInvalido{
      if( i > size() || i < 0){
        throw new ExcepcionIndiceInvalido("Posicion invalida");
      }
      if(i == 0){
        eliminaPrimero();
      }
      if(i == size()){
        eliminaUltimo();
      }
      Nodo aux = cabeza;
      if(i<=(size()/2)){
        for(int j = 1; j< i ;j++ ) {
          aux= aux.siguiente;
        }
        aux.siguiente = aux.siguiente.siguiente;
        longitud --;
        return aux.e;
      }else if(i>=(size()/2)){
        aux = rabo;
        for(int k = size()-1; i < k ;k--) {
          aux= aux.anterior;
      }
      aux.anterior = aux.anterior.anterior;
      longitud --;
      return aux.e;
      }
      return aux.e;
    }

    /**
    * Regresa la cantidad de elementos contenidos en la lista.
    * @return la cantidad de elementos contenidos.
    */
    public int size(){
      return longitud;
    }

    /**
    * Revierte los elementos de la lista. Esto es, da la reversa de la lista.
    */
    public DoubleLinkedList<T> revert(){
      DoubleLinkedList <T> r = new DoubleLinkedList();
      Nodo aux = cabeza;
      while(aux != null){
        r.agregaInicio(aux.e);
        aux = aux.siguiente;
      }
      return r;
    }

    /**
    * Da la mitad derecha o izquierda de una lista.
    * @param side la mitad que recortar de la lista original.
    * true - mitad derecha.
    * false - mitad izquierda.
    * @return una nueva lista con la mitad de los elementos.
    */
  /* public TDAList cut(boolean side){
      if(side == true){
        for(int i = 1; i<= (size()/2)%2 ;i++ ){

          }
       }
    }*/

    /**
    * Da una cadena con los elementos contenidos en la lista.
    * @return una representación de la lista.
    */
    public String toString(){
      if(isEmpty()){
        return "[]";
      }
      String s = "[" + cabeza.e.toString();
      Nodo aux = cabeza.siguiente;
      while(aux != null){
        s += ", " + aux.e.toString();
        aux = aux.siguiente;
      }
      return s + "]";
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
      @SuppressWarnings("unchecked") DoubleLinkedList<T> lista = (DoubleLinkedList<T>)objeto;
      if(this.longitud != lista.longitud || lista == null){
        return false;
      }
      Nodo n = cabeza;
      Nodo h = lista.cabeza;
      while(n != null){
        if(n.e.equals(h.e)){
          n = n.siguiente;
          h = h.siguiente;
        }else{
          return false;
        }

      }
      return true;
    }
    /**
    * Da un iterador para la lista.
    * @return un iterador para la estructura.
    */
    public Iterator listIterador(){
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorList<T> iteradorLista() {
        return new Iterador();
    }
}
