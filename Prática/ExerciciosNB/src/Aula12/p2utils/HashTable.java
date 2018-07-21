package Aula12.p2utils;


import static java.lang.System.*;

public class HashTable<E> {

    /**
     * {@code HashTable} constructor
     */
    @SuppressWarnings("unchecked")
    public HashTable(int minCapacity) {
	assert minCapacity > 0;
	int len = minCapacity; // should be the nearest prime number
	array = (KeyValueList<E>[]) new KeyValueList[len];
	clear();
    }

    /**
     * Updates the element associated to the given key, if the key already
     * exists; otherwise, inserts a new pair with the given key and element
     *
     * @param k a key
     * @param e an element
     * @return {@code true} if the key was added (size increased), otherwise
     * {@code false}.
     */
    public boolean set(String key, E elem) {
	int pos = hashFcn(key);
	boolean newelem = array[pos].set(key, elem);
	if (newelem) {
	    size++;
	}

	assert contains(key) && get(key).equals(elem);
	return newelem;
    }

    /**
     * @param A key
     * @return The element associated to the given key
     */
    public E get(String key) {
	assert contains(key);

	int pos = hashFcn(key);
	return array[pos].get(key);
    }

    /**
     * Removes the given key and associated element
     *
     * @param A key
     */
    public void remove(String key) {
	assert contains(key);

	int pos = hashFcn(key);
	array[pos].remove(key);
	size--;

	assert !contains(key);
    }

    /**
     * Checks if the given key exists in the list
     *
     * @param k a key
     * @return {@code true} if the key exists and {@code false} otherwise
     */
    public boolean contains(String key) {
	int pos = hashFcn(key);
	return array[pos].contains(key);
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    /**
     * @return Number of elements in the list
     */
    public int size() {
	return size;
    }

    /**
     * Clear the table.
     */
    public void clear() {
	for (int i = 0; i < array.length; i++) {
	    array[i] = new KeyValueList<E>();
	}
	size = 0;
    }

    // Devolve o índice correspondente à chave str.
    // (É o hashCode da str "enrolado" mod N, onde N=array.length.)
    private int hashFcn(String str) {
	int result = str.hashCode() % array.length;
	if (result < 0) {
	    result += array.length;
	}
	assert 0 <= result && result < array.length;  // pós-condição
	return result;
    }

    public String[] keys(){
	String[] arroyada = new String[size];
	int pos = 0;
	for(int i = 0;i < array.length;i++){
	    String[] k = array[i].keys();
	    arraycopy(k,0,arroyada,pos,k.length);
	    pos += k.length;
	}
	return arroyada;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* 
    
    public String[] keys() {
	String[] r = new String[size];
	int pos = 0;
	for (int i = 0; i < array.length; i++) {
	    String[] k = array[i].keys();
	    arraycopy(k,0,r,pos,k.length);
	    pos += k.length;
	}	
	return r;
    }
    
    public String toString(){
	String str = "{";
	boolean useComma = false;
	String[] k = keys();
	for (int i = 0; i < k.length; i++) {
	    if(useComma)
		str = str + ",";
	    str = str + "(" + k[i] + "," + get(k[i]) + ")";
	    useComma = true;
	}
	return str + "}";
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private KeyValueList<E>[] array;
    private int size = 0;

    // fazer aqui as funções pedidas no guião
}
