package fciencias.edatos.practica05;
import java.util.Scanner;

/**
* Implementación de un árbol binario de busqueda.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
* @version 3.0 Noviembre 2021 (Anterior 2.0 Julio 2021).
* @since Estructuras de Datos 2022-1.
*/
public class BinarySearchTree<K extends Comparable<K>, T> implements TDABinarySearchTree<K, T>{

	/**
	 * Nodo para un árbol binario de búsqueda.
	 */
	public class BinaryNode{

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
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public BinaryNode(K key, T element, BinaryNode parent){
			this.key = key;
			this.element = element;
			this.parent = parent;
		}
	}

	/** Root */
	private BinaryNode root;

  /**
  * Recupera el objeto con clave k.
  * @param k la clave a buscar.
  * @return el elemento con clave k o null si no existe.
  */
	@Override
	public T retrieve(K k){
		BinaryNode node = retrieve(root, k);
		if(node == null)
			return null;
		return node.element;
	}

	private BinaryNode retrieve(BinaryNode actual, K k){
		// No se encuentra el elemento
		if(actual == null)
			return null;

		// Si encontramos el elemento
		if(actual.key.compareTo(k) == 0)
			return actual;

		// Comparamos los elementos
		if(k.compareTo(actual.key) < 0){ // Verificamos en la izquierda
			return retrieve(actual.left, k);
		} else { // Verificar en la derecha
			return retrieve(actual.rigth, k);
		}
	}

	@Override
	public void insert(T e, K k){
		BinarySearchTree<K,T> Tree = new BinarySearchTree();
		BinaryNode node = new BinaryNode(k,e,null);
		if(Tree.isEmpty()){
			Tree.root = node;
			return;
		}
		 insert(node, e,k);
		// Si es vacío entonces insertamos al nuevo elemento como la raíz del árbol
		// Invocar el método insert de tres parámetros
	}

	private void insert(BinaryNode actual, T e, K k){
		if (actual.key.compareTo(k) <= 0){
			if(actual.left == null){
				actual.left = actual;
			}
			else{
				insert(actual.left,e,k);
			}
			if(actual.key.compareTo(k) >= 0){
				if(actual.rigth == null){
					actual.rigth = actual;
				}
			}
			else{
				insert(actual.rigth,e,k);
			}
		}
		// Comparamos las claves: la clave de actual con k. Con compareTo
		// Si la clave es menor verificamos que el hijo izquierdo no sea null
		// * Si es null insertamos el nuevo elemento como hijo izquierdo del actual. Si no recursión
		// Si la clave es mayor
		// * Si es null insertamos el nuevo elemento como hijo derecho del actual. Si no recursión
	}
/*
	@Override
	public T delete(K k){
		// retieve(root, k)
		// Si ese resultado es null -> regresar null
		// Crear una variable que almacene el elemento en retrieve

		// Cuando tiene dos hijos
		// Buscamos al maximo de los mínimos
		// hacemos un swap actual con el maximo de los mínimos
		// eliminar el nodo con el que se hizo swap

		// Cuando no tiene hijos
		// Verificar si es hijo izquierdo o es hijo derecho
		// Si es hijo izquiero hacer null el izquierdo del padre
		// Si es hijo derecho hacer null el derecho del padre

		// Cuando solo tiene un hijo
		// Swap con el hijo, ya sea derecho o izquierdo
		// Borramos al hijo con el que se hizo swap. Podemos hacer null a ambos hijos
		return null;
	}
	*/
	/**
	* Verifica si el árbol es vacío.
	* @return true si el árbol es vacío, false en otro caso.
	*
	*/
	@Override
	public boolean isEmpty(){
		if (root == null){
				return  true;
		}
	 return false;

	}
	/*
	@Override
	public T findMin(){
		// Verificar que no sea vacío -> return null
		// Mientras sí tenga hijo izquierdo -> Que actual se mueva al izquierdo
		// Ya encontramos al nodo con clave menor
		return null;
	}
  */
	@Override
	public T findMax(){
		BinaryNode node = findMax(root,root.element);
		if(node == null)
			return null;
		return node.element;
		}
		public BinaryNode findMax(BinaryNode act, T element){
			if(act == null)
				return null;
			while(act.rigth != null){
				act = act.rigth;
			}
			return findMax(act,element);
		}



	@Override
	public void preorden(){
			preorden(root);
	}
	public void preorden(BinaryNode B){
		if(B == null){
			return;
		}
		System.out.println(B.element + " ");
		preorden(B.left);
		preorden(B.rigth);

	}
	@Override
	public void inorden(){

	inorder(root);
	}

 private void inorder(BinaryNode B){
	  if(B == null){
			return;
		}
		inorder(B.left);
		System.out.println(B.element + " ");
		inorder(B.rigth);
 }
	@Override
	public void postorden(){
			postorden(root);
	}
	public void postorden(BinaryNode B){
		if(B == null){
			return;
		}
		postorden(B.left);
		postorden(B.rigth);
		System.out.println(B.element + " ");
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer,Object>  tree = new BinarySearchTree();


	        Scanner sc = new Scanner(System.in);

	        do{
	            System.out.println(
	            "[1] Regresar el elemento asociado dado número entero \n"+
	            "[2] Inserta un elemento en el arbol dado un caracter y un número entero\n"+
	            "[3] Elimina elementos del arbol dado un número entero\n"+
	            "[4] Regresa el elemnto con el número minimo en el arbol\n"+
	            "[5] Regresa el elemnto con el número máximo en el arbol\n"+
	            "[6] ¿Es vacio el arbol?\n"+
	            "[7] Recorrido preorden\n"+
	            "[8] Recorrido inorden\n"+
	            "[9] Recorrido postorden\n"+
	            "[10] Salir del menu\n"+
	            "Elige una opcion: ");

	            int opcion = sc.nextInt();
	            sc.nextLine();

	            switch(opcion){
	                case 1:
	                    System.out.println("Ingresa el número para buscar el elemento ");
	                    int i = sc.nextInt();
	                    sc.nextLine();
	                    tree.retrieve(i);
	                    break;
	                case 2:
	                    System.out.println("Ingresa el caracter y el número entero para ingresarlos en el arbol");
	                    char f = sc.next().charAt(0);
											int j = sc.nextInt();
											sc.nextLine();
	                    tree.insert(f,j);
	                    break;
	                case 3:
											System.out.println("Ingresa el número para eliminar el nodo ");
											int h = sc.nextInt();
											sc.nextLine();
	                    //tree.delete();
	                    break;
	                case 4:
	                     //System.out.println("El elemento minimo es"+tree.findMin()+".");
	                    break;
	                case 5:
	                    System.out.println("El elemento máximo es"+tree.findMax()+".");
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
	                case 10:
	                    break;
	                default:
	                    System.out.println("Opción inválida");
	            }
	        } while(true);
				}
	    }
