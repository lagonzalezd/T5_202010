package model.data_structures;

public class Stack<T> implements IStack<T> {

    // Atributos
    private int tamano;
    private Node<T> top;

    //Constructor
    public Stack() {
        top = null;
        tamano = 0;
    }

    //Metodos

    /**
     * Se agrega un elemento al principio de la pila.
     *
     * @param pElemento
     */
    public void push(T pElemento) {
        Node<T> nuevoPrimero = new Node<T>(pElemento);
        if (estaVacia()) {
            top = nuevoPrimero;
            tamano++;
        } else {
            nuevoPrimero.cambiarSiguiente(top);
            top = nuevoPrimero;
            tamano++;
        }
    }

    /**
     * Se da el primero de la pila y se elimina.
     *
     * @return Primer elemento de la pila.
     */
    public T pop() {
        if (estaVacia()) {
            return null;
        } else {
            T temp = top.darElemento();
            if (top.darSiguiente() != null) {
                top = top.darSiguiente();
                tamano--;
                return temp;
            } else {
                top = null;
                tamano--;
                return temp;
            }

        }
    }

    /**
     * Se comprueba que hayan elementos en la pila.
     *
     * @return True si está vacia, false si hay al menos un elemento.
     */
    public boolean estaVacia() {
        return top == null ? true : false;
    }

    /**
     * Metodo que retorna el tamaño de la pila.
     *
     * @return Tamaño de la pila.
     */
    public int darTamano() {
        return tamano;
    }

    /**
	 * Metodo que regresa el primer elemento de la pila sin eliminarlo.
     * @return Primer elemento de la pila.
     */
    public T peek() {
        if (estaVacia()) {
            return null;
        } else {
			return top.darElemento();
        }
    }
}
