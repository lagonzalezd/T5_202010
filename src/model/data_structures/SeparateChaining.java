package model.data_structures;

public class SeparateChaining<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;
    
    private int m;   
    
    private TablaSimbolos<Key, Value>[] st; 
    
    
    /**
     * Inicializa una tabla de simbolos con m cadenas.
     * @param m el numero inicial de cadenas
     */
    public SeparateChaining(int m) {
        this.m = m;
        st = (TablaSimbolos<Key, Value>[]) new TablaSimbolos[m];
        for (int i = 0; i < m; i++)
            st[i] = new TablaSimbolos<Key, Value>();
    } 

    // se cambia el tamanio de la tabla de hash para tener el numero dado de cadenas,
    // se le hace "rehash" a todas las llaves
    private void resize(int chains) {
    	SeparateChaining<Key, Value> temp = new SeparateChaining<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // valor de hash entre 0 y m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    /**
     * devuelve el numero de pares de valor-llave que esta en la tabla de simbolos
     *
     * @return el numero de pares de valor-llave que esta en la tabla de simbolos
     */
    public int size() {
        return n;
    } 

    /**
     * Devuelve true si la tabla de simbolos esta vacia
     *
     * @return true si la tabla de simbolos esta vacia, false de lo contrario
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Devuelve true si la tabla de simbolos contiene la llave, false de lo contrario.
     *
     * @param  key la llave
     * @return true si la tabla de simbolos contiene la llave, false de lo contrario.
     * @throws IllegalArgumentException si el parametro "key" es null
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    /**
     * Returns el valor asociado a la llave.
     *
     * @param  key la llave
     * @return el valor asociado a la llave.
     * @throws IllegalArgumentException si "key" es null
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    /**
     * inserta el par de valor-llave especificado.
     * 
     * @param  key la llave
     * @param  val el valor
     * @throws IllegalArgumentException if "key" es null
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("el primer argumento es null");
        if (val == null) {
            delete(key);
            return;
        }

        // se duplica el tamaño si la longitud de la lista es mayor o igual a 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    /**
     * Remueve la llave especificada con su valor asociado.  
     *
     * @param  key la llave
     * @throws IllegalArgumentException si key es null
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("el argumento es null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 

}
