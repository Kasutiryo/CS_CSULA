package LAB_04;

import net.datastructures.Stack;

public class MyLeakyStack<E> extends SinglyLinkedList<E> implements Stack<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

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
	public void push(E e) {
		// TODO Auto-generated method stub
		if (list.size() < 5)			//For testing purposes, this "history" limit
			list.addFirst(e);			//is set to only 5, after so it will remove
		else if (list.size() >= 5) {	//the oldest element in the list.
			list.removeLast();
			list.addFirst(e);
		}
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return (E) list.first();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E tmp = (E) list.first();
		list.removeFirst();
		return tmp;
	}
	
	public static void main(String[] args) {
		
		MyLeakyStack<String> list = new MyLeakyStack<String>();
		
		list.push("a");
		System.out.println(list.top());
		list.push("b");
		System.out.println(list.top());
		list.push("c");
		System.out.println(list.top());
		list.push("d");
		System.out.println(list.top());
		list.push("e");
		System.out.println(list.top());		
		System.out.println(list.size());
		list.push("f");
		System.out.println(list.top());
		System.out.println(list.size());
		
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.isEmpty());
	}

}
