package model.data_structures;

public class TablaSimbolos<Key, Value> {
    
	//numero de pares de llaves
	private int n;
    private Node first;

    // La clase nodo que se usa para la lista encadenada basica
    private class Node 
    {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * Inicializacion de tabla de simbolos vacia
     */
    public TablaSimbolos(){
    	
    }

    /**
     * metodo que devuelve el numero de pares de valores y llaves
     */
    public int size() {
        return n;
    }

    /**
     * Devuelve true si el tabla esta vacia
     * @return true si esta vacio, false de lo contrario
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true si la tabla de simbolos contiene una llave particular.
     *
     * @param  key la llave
     * @return true si lo contiene, false de lo contrario
     * @throws IllegalArgumentException si la llave es null
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("el argumento es invalido");
        return get(key) != null;
    }

    /**
     * Devuelve el valor asociado con la tabla de simbolos
     *
     * @param  key la llave
     * @return el valor asociado a la tabla si la tabla lo contiene, en caso de encontrarlo se devuelve null
     * @throws IllegalArgumentException si "key" es null
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("el argumento es invalido"); 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     * Inserta el par de valor y llave especificado
     *
     * @param  key la llave
     * @param  val el valor
     * @throws IllegalArgumentException si "key" es null
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("El primer argumento es invalido"); 
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * Remueve la llave especificada y su asociacion de valor en la tabla 
     * 
     * @param  key la llave
     * @throws IllegalArgumentException si "key" es null
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("El argumento que ingreso es invalido"); 
        first = delete(first, key);
    }

    // Borra la llave de la lista encadenada
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys()  
    {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}