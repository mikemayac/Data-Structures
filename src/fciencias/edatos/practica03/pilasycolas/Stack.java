package fciencias.edatos.practica03.pilasycolas;
import java.util.EmptyStackException;


/**
 * Implementación de una pila basada en una lista doblemente ligada.
 *  Implementa las operaciones del TDAStack.
 * @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Stack<T> implements TDAStack<T> {

    /** Lista base */
    public DoubleLinkedList<T> list = new DoubleLinkedList<>();

    /**
     * Limpia la pila. Elimina todos los elementos.
     */
    @Override
    public void clear(){
        list.clear();
    }

    /**
  	 * Verifica si la pila está vacía.
  	 * @return true si la pila no contiene elementos, false en otro caso.
  	 */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * Remueve y regresa el tope de la pila.
     * @return el tope de la pila.
     * @throws EmptyStackExpception si la pila está vacía.
     */
    @Override
    public T pop() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.remove(0);
    }

    /**
     * Agrega un nuevo elemento a la pila.
     * @param e el elemento a agregar.
     */
    @Override
    public void push(T e){
        list.add(0, e);
    }

    /**
  	 * Regresa el tope de la pila.
  	 * @throws EmptyStackExpception si la pila está vacía.
  	 */
    @Override
    public T top() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.get(0);
    }
}
