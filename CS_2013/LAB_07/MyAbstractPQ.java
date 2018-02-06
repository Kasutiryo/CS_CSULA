package LAB_07;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class MyAbstractPQ<K, V> extends ArrayList<Entry<K,V>> implements PriorityQueue<K, V>{

	private Comparator<K> comp;

	@Override
	public int size(){
		return super.size();
	}

	@Override
	public boolean isEmpty(){
		return super.isEmpty();
	}

	public Entry<K, V> top(){
		if(size() > 0) return get(0);
		return null;
	}

	// implement these two methods for max heap and min heap
	public abstract Entry<K, V> enqueue(K key, V value);
	public abstract Entry<K, V> dequeue();

	@Override
	public boolean add(Entry<K, V> element){
		enqueue(element.getKey(), element.getValue());
		return true;
	}

	@Override
	public Entry<K,V> remove(int i){
		return dequeue();
	}

	public int parent(int i){
		return (int) Math.floor( (i - 1)/2);
	}

	public int leftChild(int i){
		return 2*i + 1;
	}

	public int rightChild(int i){
		return 2*i + 2;
	}

	public void swap(int a, int b){
		Entry<K,V> temp = get(a);
		set(a, get(b));
		set(b, temp);
	}

	protected int compare(Entry<K,V> a, Entry<K, V> b){
		return comp.compare(a.getKey(), b.getKey());
	}
}

interface Entry<K,V>{
	K getKey();
	V getValue();
}

interface PriorityQueue<K, V>{
	int size();
	boolean isEmpty();
	Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException;
	Entry<K, V> top();
	Entry<K, V> dequeue();
}

class PQEntry<K, V> implements Entry<K, V>{
	private K key;
	private V value;
	public PQEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void setKey(K key) {
		// TODO Auto-generated method stub
		this.key = key;
	}

	public void setValue(V value) {
		// TODO Auto-generated method stub
		this.value = value;
	}
}

class MyComparator<E> implements Comparator<E>{

	@Override
	public int compare(E o1, E o2) throws ClassCastException{
		// TODO Auto-generated method stub
		return ((Comparable<E>) o1).compareTo(o2);
	}

}