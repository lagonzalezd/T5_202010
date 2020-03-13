package model.data_structures;

public interface INode<T> {
	
	public Node<T> darSiguiente();
	public T darElemento();
	public void cambiarElemento( T pElemento );
	public void cambiarSiguiente(Node<T> pNodo);
}
