package LAB_05;

import java.util.Iterator;
import net.datastructures.Position;
import net.datastructures.PositionalList;
import java.util.ArrayList;


public class MyArrayPositionalList<E> implements PositionalList<E>{

	private static int index = 0;
	
	private static class Node<E> implements Position<E> {
		
		private E reference;
		private Node<E> prev;
		private Node<E> next;
		private int i;
		public Node(E r, Node<E> p, Node<E> n) {
			
			i = index;
			index++;
			reference = r;
			prev = p;
			next = n;
		}
		
		public void setReference(E r) { 
			reference = r;
		}
		@Override
		public E getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			return reference;
		}
		
		public Node<E> getPrev() {
			return prev;
		}
		
		public void setPrev(Node<E> p) {
			prev = p;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
	}
	private ArrayList<Node<E>> list = new ArrayList<Node<E>>();
	
	
	
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return list.isEmpty();
    }

    @Override
    public Position<E> first() {
        // TODO Auto-generated method stub
        return list.get(0);
    }

    @Override
    public Position<E> last() {
        // TODO Auto-generated method stub
        return list.get(list.size() - 1);
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Position<E> cursor = first();
        Position<E> prev = null;
        while (cursor != p) {
        	prev = cursor;
        	cursor = after(p);
        }
        return prev;
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        for (Position curr: list) {
        	if (curr.equals(p)) 
        			return curr;
        }
        return null;
    }

    @Override
    public Position<E> addFirst(E e) {
        // TODO Auto-generated method stub
    	if(isEmpty())
    		list.add(0, new Node(e, null, null));
    	else {
    		list.add(0, new Node(e, null, list.get(0)));
    		list.get(1).setPrev(list.get(0));
    	}
    		return list.get(0);
    }

    @Override
    public Position<E> addLast(E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static void main(String[] args) {
    
    	MyArrayPositionalList list = new MyArrayPositionalList();
    	
    	System.out.println(list.addFirst("first"));
    }
}
