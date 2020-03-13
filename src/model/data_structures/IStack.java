package model.data_structures;

public interface IStack<T> {
	
	public void push(T pElemento);
	
	public T pop() throws Exception;
	
	public boolean estaVacia();
	
	public int darTamano();
	
	public T peek() throws Exception;
	
}
