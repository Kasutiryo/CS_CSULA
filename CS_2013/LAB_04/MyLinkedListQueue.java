package LAB_04;

import java.util.LinkedList;

import net.datastructures.Queue;

public class MyLinkedListQueue<E> extends LinkedList<E> implements Queue<E> {

	private LinkedList<E> list = new LinkedList<>();

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.pop();
	}

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

	public static void main(String[] args) {
		
		MyLinkedListQueue<String> list = new MyLinkedListQueue<String>();
		
		list.enqueue("a");
		System.out.println(list.first());
		list.enqueue("b");
		System.out.println(list.first());
		list.enqueue("c");
		System.out.println(list.first());
		System.out.println(list.size());
		
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.isEmpty());
	}
}
