package LAB_07;

import java.util.ArrayList;
import java.util.Comparator;
import net.datastructures.AbstractPriorityQueue;
import net.datastructures.ArrayQueue;
import net.datastructures.Entry;


public class MyPriorityHeapMin<K, V> extends AbstractPriorityQueue<K, V>{

    int timestamp = 0;
    
    private ArrayList<Entry<K, V>> heap = new ArrayList<>();
    
    public MyPriorityHeapMin() { super(); } //constructs any empty list
    
    public MyPriorityHeapMin(ArrayList<Entry<K,V>> data) {	//inserts data into the list
    	super();											//using the given ArrayList
    	for(Entry<K, V> item: data) {						//of Entry's
    		insert(item.getKey(), item.getValue());
    	}
    }
    
    //methods to create tree-like structure with tree complexity
    protected int parent(int j) { return (j-1) / 2; } 
    protected int left(int j) { return 2*j + 1; }
    protected int right(int j) { return 2*j + 2; }
    protected boolean hasLeft(int j) { return left(j) < heap.size(); }
    protected boolean hasRight(int j) { return right(j) < heap.size(); }
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        // TODO Auto-generated method stub
    	heap.add(new PQEntry<K, V>(key, value));
    	Entry<K, V> newest = heap.get(heap.size() - 1);
    	Entry<K, V> parent = heap.get(parent(heap.indexOf(newest)));
    	while (compare(newest, parent) < 0) {
    		Entry<K, V> tmp = newest;
    		heap.set(heap.indexOf(newest), parent);
    		heap.set(heap.indexOf(parent), tmp);
    		newest = parent;
    	}
    	return newest;
    }

    @Override
    public Entry<K, V> min() {
        // TODO Auto-generated method stub
    	if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        // TODO Auto-generated method stub
    	if(heap.isEmpty()) return null;
    	int master = 0;
    	heap.set(0, heap.get(heap.size() - 1));
    	heap.remove(heap.size() - 1);
    	boolean hasLeft = hasLeft(master);
    	while(hasLeft) {
    		int smallest = left(master);
    		if(compare(heap.get(left(master)), heap.get(right(master))) > 0) 
    			smallest  = right(master);
    		if(compare(heap.get(master), heap.get(smallest)) > 0) {
    			Entry<K, V> tmp = heap.get(master);
    			heap.set(master, heap.get(smallest));
    			heap.set(smallest, tmp);
    			master = smallest;
    		} else hasLeft = false;		
    	}
    	return heap.get(master);
    }
}