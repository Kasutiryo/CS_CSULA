package LAB_04;

import java.util.ArrayList;
import net.datastructures.Stack;

public class MyArrayStack<E> extends ArrayList<E> implements Stack<E> {

	private ArrayList<E> list = new ArrayList<>();

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.add(0, e);
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.get(0);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E tmp = list.get(0);
		list.remove(0);
		return tmp;
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
		
		MyArrayStack<String> list = new MyArrayStack<String>();
		
		list.push("a");
		System.out.println(list.top());
		list.push("b");
		System.out.println(list.top());
		list.push("c");
		System.out.println(list.top());
		System.out.println(list.size());
		
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.isEmpty());
	}

}


