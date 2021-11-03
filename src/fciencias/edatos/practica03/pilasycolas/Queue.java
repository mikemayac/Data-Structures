package fciencias.edatos.practica03.pilasycolas;

/**
 * Implementación de una colas basada en una lista doblemente ligada.
 *  Implementa las operaciones del TDAQueue.
 * @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Queue<T> implements TDAQueue<T>{

    /** Lista */
    private DoubleLinkedList<T> lista = new DoubleLinkedList<>();

    /**
  	 * Limpia la cola. Elimina todos los elementos.
  	 */
    @Override
    public void clear(){
        lista.clear();
    }

    /**
  	 * Remueve y regresa el siguiente elemento en la cola.
  	 * @return el siguiente en la cola o null si es vacía.
  	 */
    @Override
    public T dequeue(){
        if(lista.isEmpty())
            return null;
        return lista.remove(0);
    }


    /**
     * Agrega un nuevo al final de la cola.
     * @param e el elemento a agregar.
  	 */
    @Override
    public void enqueue(T e){
        lista.add(lista.size(), e);
    }

    /**
     * Devuelve el elemento siguiente en la cola, sin eliminarlo.
     * @return el siguiente elemento en la cola o null si es vacía.
     */
    @Override
    public T first(){
        if(lista.isEmpty())
            return null;
        return lista.get(0);
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola no contiene elementos, false en otro caso.
     */
    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }
}    
