package LAB_06;

import java.util.ArrayList;

import net.datastructures.AbstractBinaryTree;
import net.datastructures.Position;

public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {

	protected static class Node<E> implements Position<E> {

		private E element;

		public Node(E e) {	
			element = e;
		}
		@Override
		public E getElement() throws IllegalStateException {
			return element;
		}
		public void setElement(E e) {
			element = e;
		}
	}

	private ArrayList<Position<E>> list = new ArrayList<>();

	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p;       // safe cast
		return node;
	}

	public void add(E e) {
		Node<E> node = new Node<E>(e);
		list.add(node);
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return list.get(2*list.indexOf(node) + 1);
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return list.get(2*list.indexOf(node) + 2);
	}

	@Override
	public Position<E> root() {
		Node<E> node = validate(list.get(0));
		return node;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (list.get((list.indexOf(node) - 1) / 2) == null) 
			throw new IllegalArgumentException("This element is the root of the tree");
		return list.get((list.indexOf(node) - 1) / 2);

	}
	
	public static void main(String[] args) { 
		
		ArrayBinaryTree<String> tree = new ArrayBinaryTree<>();
		
		tree.add("/");
		tree.add("*");
		tree.add("+");
		tree.add("+");
		tree.add("4");
		tree.add("-");
		tree.add("2");
		tree.add("3");
		tree.add("1");
		tree.add("");
		tree.add("");
		tree.add("9");
		tree.add("5");
		tree.add("");
		tree.add("");
		
		Position<String> p = tree.list.get(5);
		
		System.out.println(tree.right(p).getElement());
	}
}
