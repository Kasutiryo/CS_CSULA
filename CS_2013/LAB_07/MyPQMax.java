package LAB_07;

import java.util.ArrayList;

public class MyPQMax<E extends Comparable<E>> extends ArrayList<E> {

	public int size(){
		return super.size();
	}

	public boolean isEmpty(){
		return super.isEmpty();
	}

	public void enqueue(E element){
		add(element);
		int me = size() - 1;
		int parent = parent(me);

		while(parent>=0 && (element.compareTo(get(parent)))>0){
			swap(me, parent);
			me = parent;
			parent = parent(me);
		}
	}


	public E dequeue(){
		if (size() <= 0) return null;

		E max = get(0);
		swap(0, size() - 1);
		remove(size() - 1);

		int me = 0;
		int lc = lc(me);
		int rc = rc(me);
		int largest;

		while(lc < size() || rc < size()){
			if(lc < size() && (get(me).compareTo(get(lc)) < 0)){
				largest = lc;
			}else{
				largest = me;
			}

			if(rc < size() && (get(largest).compareTo(get(rc)) < 0)){
				largest = rc;
			}

			if(me != largest){
				swap(me, largest);
			}

			me = largest;
			lc = lc(me);
			rc = rc(me);

		}
		return max; 
	}
	
	public E top(){
		if (!isEmpty()) return get(0);
		return null;
	}

	public void swap(int a, int b){
		E temp = get(a);
		set(a, get(b));
		set(b, temp);
	}
	public int parent(int i){
		return (int) Math.floor((i -1) /2);
	}

	public int lc(int i){
		return 2*i + 1;
	}

	public int rc(int i){
		return 2*i + 2;
	}
}
