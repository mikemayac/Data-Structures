package fciencias.edatos.practica05;

import java.util.Scanner;

import org.w3c.dom.Node;

/**
 * Implementación de un árbol binario de busqueda.
 * 
 * @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya
 *         Castrejón 417112602
 * @version 3.0 Noviembre 2021 (Anterior 2.0 Julio 2021).
 * @since Estructuras de Datos 2022-1.
 */
public class BinarySearchTree<K extends Comparable<K>, T> implements TDABinarySearchTree<K, T> {

	/**
	 * Nodo para un árbol binario de búsqueda.
	 */
	public class BinaryNode {

		/** Clave. */
		public K key;

		/** Elemento. */
		public T element;

		/** Padre del nodo. */
		public BinaryNode parent;

		/** Hijo izquierdo. */
		public BinaryNode left;

		/** Hijo derecho. */
		public BinaryNode rigth;

		/**
		 * Crea un nuevo nodo.
		 * 
		 * @param key     la clave.
		 * @param element el elemento a almacenar.
		 * @param parent  el padre del nodo.
		 */
		public BinaryNode(K key, T element, BinaryNode parent) {
			this.key = key;
			this.element = element;
			this.parent = parent;
		}
	}

	/** Root */
	private BinaryNode root;

	/**
	 * Recupera el objeto con clave k.
	 * 
	 * @param k la clave a buscar.
	 * @return el elemento con clave k o null si no existe.
	 */
	@Override
	public T retrieve(K k) {
		BinaryNode node = retrieve(root, k);
		if (node == null)
			return null;
		return node.element;
	}

	private BinaryNode retrieve(BinaryNode actual, K k) {
		// No se encuentra el elemento
		if (actual == null)
			return null;

		// Si encontramos el elemento
		if (actual.key.compareTo(k) == 0)
			return actual;

		// Comparamos los elementos
		if (k.compareTo(actual.key) < 0) { // Verificamos en la izquierda
			return retrieve(actual.left, k);
		} else { // Verificar en la derecha
			return retrieve(actual.rigth, k);
		}
	}

	@Override
	public void insert(T e, K k) {

		if (this.isEmpty()) {
			this.root = new BinaryNode(k, e, null);
			;
			return;
		}
		BinaryNode act = root;
		insert(act, e, k);
		// Si es vacío entonces insertamos al nuevo elemento como la raíz del árbol
		// Invocar el método insert de tres parámetros
	}

	private void insert(BinaryNode actual, T e, K k) {
		if (k.compareTo(actual.key) < 0) {
			if (actual.left == null) {
				actual.left = new BinaryNode(k, e, actual);
			} else {
				insert(actual.left, e, k);

			}
		} else {

			if (actual.rigth == null) {
				actual.rigth = new BinaryNode(k, e, actual);
			}

			else {
				insert(actual.rigth, e, k);
			}
		}
	}

	// Comparamos las claves: la clave de actual con k. Con compareTo
	// Si la clave es menor verificamos que el hijo izquierdo no sea null
	// * Si es null insertamos el nuevo elemento como hijo izquierdo del actual. Si
	// no recursión
	// Si la clave es mayor
	// * Si es null insertamos el nuevo elemento como hijo derecho del actual. Si no
	// recursión

	@Override
	public T delete(K k) {
		// retieve(root, k)
		// Si ese resultado es null -> regresar null
		// Crear una variable que almacene el elemento en retrieve

		BinaryNode node = this.retrieve(root, k);

		if (node == null) {
			System.out.println("No existen elementos con esa clave.");
			return null;
		}

		T deleted = node.element;

		// Si tiene dos hijos
		if (node.left != null && node.rigth != null) {

			BinaryNode maxOfMin = this.maximumOfMin(node);
			delete(maxOfMin.key);
			this.swap(node, maxOfMin);
		System.out.println("El elemento ha sido eliminado correctamente");
		return deleted;

		}

		//Si no tiene hijos
		if(node.left == null && node.rigth == null){
	    
            //Verificamos que el nodo a eliminar no sea la raiz
            if(node.parent != null){
		
                //Verificamos si el nodo a eliminar es hijo izquierdo o derecho
                if(node.parent.left == node){
                    node.parent.left = null;
                }
		
                if(node.parent.rigth == node){
                    node.parent.rigth = null;
                }

		System.out.println("El elemento se eliminó correctamente");
                return deleted;
		
            }else{
		
		//Si es la raiz
                this.root = null;
		System.out.println("El elemento se eliminó correctamente");
                return deleted;
            }
        }

		 // Si solo tiene un hijo izquierdo
		 if(node.left != null){
	    
            //Verificamos que el nodo a eliminar no sea la raiz
            if(node.parent != null){
		
                //Verificamos si el nodo a eliminar es hijo izquierdo o derecho
                if(node.parent.left == node){
		    
                    node.left.parent = node.parent;
                    node.parent.left = node.left;
                }
		
                if(node.parent.rigth == node){
		    
                    node.left.parent = node.parent;
                    node.parent.rigth = node.left;
                }

		System.out.println("El elemento se eliminó correctamente");
                return deleted;
		
            }else{
		
		//Si es la raiz
                node.left.parent = null;
                this.root = node.left;
		System.out.println("El elemento se eliminó correctamente");
		return deleted;
            }
        }

        // Cuando solo tiene un hijo derecho
        if(node.rigth != null){
	    
            //Verificar que el nodo a eliminar no sea la raiz
            if(node.parent != null){
		
                //Verificamos si el nodo a eliminar es hijo izquierdo o derecho
                if(node.parent.left == node){
		    
                    node.rigth.parent = node.parent;
                    node.parent.left = node.rigth;
                } 
		
                if(node.parent.rigth == node){
		    
                    node.rigth.parent = node.parent;
                    node.parent.rigth = node.rigth;
                }

		System.out.println("Elemento eliminado correctamente");
		return deleted;
		
            }else{

		//Caso en el que sea la raiz
                node.rigth.parent = null;
                this.root = node.rigth;
		System.out.println("Elemento eliminado correctamente");
		return deleted;
            }
        }

        return null;
    }

	

	/**
	 * Metodo que regresa el hijo maximo de los minimos. del nodo que pasa como
	 * parámetro.
	 * 
	 * @param nodo nodo a partir del cual buscaremos
	 * @return nodo que es el maximo de los minimos
	 */
	public BinaryNode maximumOfMin(BinaryNode node) {

		// Caso en el que el nodo sea null
		if (node == null)
			return null;

		// Caso en el que el mismo nodo sea el maximo de los minimos
		if (node.left == null)
			return node;

		// Iterador de nodos que inicia en su nodo izquierdo
		BinaryNode iterador = node.left;

		// Mientras el nodo no tenga hijo derecho
		while (iterador.rigth != null) {
			iterador = iterador.rigth;
		}

		return iterador;
	}

	/**
	 * Metodo swap, hace intercambios entre elementos del nodo1 y nodo2
     * @param nodo1 al que se le cambiará el elemento por el nodo2
     * @param nodo2 que contiene el elemento a colocar en nodo1
     */
    public void swap(BinaryNode nodo1, BinaryNode nodo2){
	
        nodo1.element = nodo2.element;
        nodo1.key = nodo2.key;
    }
	

	/**
	 * Verifica si el árbol es vacío.
	 * 
	 * @return true si el árbol es vacío, false en otro caso.
	 *
	 */
	@Override
	public boolean isEmpty() {
		
		return this.root == null;

	}

	@Override
	public T findMin() {

		// Primero verificamos que no sea vacio, si es vacio regresa null.
		if (this.isEmpty())
			return null;

		BinaryNode act = root;

		// Mientras haya un hijo izquierdo, muevete al izquierdo.
		while (act.left != null) {
			act = act.left;
		}
		return act.element;
	}

	@Override
	public T findMax() {
		if (this.isEmpty())
			return null;
		BinaryNode act = root;
		while (act.rigth != null) {
			act = act.rigth;
		}
		return act.element;
	}

	@Override
	public void preorden() {
		preorden(root);
	}

	public void preorden(BinaryNode B) {
		if (B == null) {
			return;
		}
		System.out.println(B.element + " ");
		preorden(B.left);
		preorden(B.rigth);

	}

	@Override
	public void inorden() {

		inorder(root);
	}

	private void inorder(BinaryNode B) {
		if (B == null) {
			return;
		}
		inorder(B.left);
		System.out.println(B.element + " ");
		inorder(B.rigth);
	}

	@Override
	public void postorden() {
		postorden(root);
	}

	public void postorden(BinaryNode B) {
		if (B == null) {
			return;
		}
		postorden(B.left);
		postorden(B.rigth);
		System.out.println(B.element + " ");
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer, Object> tree = new BinarySearchTree();

		Scanner sc = new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println(
					  "[1] Regresar el elemento asociado dado número entero \n"
					+ "[2] Inserta un elemento en el arbol dado un caracter y un número entero\n"
					+ "[3] Elimina elementos del arbol dado un número entero\n"
					+ "[4] Regresa el elemnto con el número minimo en el arbol\n"
					+ "[5] Regresa el elemnto con el número máximo en el arbol\n" 
					+ "[6] ¿Es vacio el arbol?\n"
					+ "[7] Recorrido preorden\n" 
					+ "[8] Recorrido inorden\n" 
					+ "[9] Recorrido postorden\n"
					+ "[10] Salir del menu\n" + "Elige una opcion: ");

			if (sc.hasNextInt()) {
				opcion = sc.nextInt();
				sc.nextLine(); // eliminate newline from input buffer
			} else{
				System.out.println("No debes ingresar letras.\n");
             	sc.nextLine(); // trash non-numeric input
			}		
			if (opcion < 1 || opcion > 10 ) {
				System.out.println("Solo puedes ingresar numeros entre 1 y 10\n");
			} 
			
			switch (opcion) {
			case 1:
				System.out.println("Ingresa el número para buscar el elemento ");
				int i = sc.nextInt();
				sc.nextLine();
				System.out.println(tree.retrieve(i)); 
				break;
			case 2:
				System.out.println("Ingresa el caracter y el número entero para ingresarlos en el arbol");
				char f = sc.next().charAt(0);
				int j = sc.nextInt();
				sc.nextLine();
				tree.insert(f, j);
				break;
			case 3:
				System.out.println("Ingresa el número para eliminar el nodo ");
				int h = sc.nextInt();
				sc.nextLine();
				tree.delete(h);
				break;
			case 4:
				System.out.println("El elemento minimo es"+tree.findMin()+".");
				break;
			case 5:
				System.out.println("El elemento máximo es" + tree.findMax() + ".");
				break;
			case 6:
				tree.isEmpty();
				break;
			case 7:
				tree.preorden();
				break;
			case 8:
				tree.inorden();
				break;
			case 9:
				tree.postorden();
				break;
			}
		} while (opcion!=10 );
		System.out.println("Gracias, vuelva pronto.");
	}
}
