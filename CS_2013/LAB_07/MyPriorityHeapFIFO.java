package LAB_07;

import java.util.ArrayList;
import net.datastructures.AbstractPriorityQueue;
import net.datastructures.Entry;

public class MyPriorityHeapFIFO<K, V> extends AbstractPriorityQueue<K, V>  {

    int timestamp = 0;
    
    private ArrayList<Entry<K,V>> heap = new ArrayList<>();
    
    public MyPriorityHeapFIFO() { super(); }					//creates and empty list
    
    public MyPriorityHeapFIFO(ArrayList<Entry<K,V>> data) {		//inserts data into the list
    	super();												//using the given ArrayList 
    	for(Entry<K, V> item: data) 							//of Entry's. BUILD-MAX-HEAP
    		insert(item.getKey(), item.getValue());
    }
    
    //methods to create tree-like structure with tree complexity
    protected int parent(int j) { return (j-1) / 2; } 
    protected int left(int j) { return 2*j + 1; }
    protected int right(int j) { return 2*j + 2; }
    protected boolean hasLeft(int j) { return left(j) < heap.size(); }
    protected boolean hasRight(int j) { return right(j) < heap.size(); }
    
    public void buildMaxHeap(int index) {
    	int algorithm = maxHeapify(index);
    	if (index == algorithm)
    		return;
    	else
    		buildMaxHeap(algorithm);
    }
    
    public int maxHeapify(int index) {
    	if(compare(heap.get(index), heap.get(parent(index))) > 0) {
    		Entry<K, V> temp = heap.get(index);
    		heap.set(index, heap.get(parent(index)));
    		heap.set(parent(index), temp);
    		index = parent(index);
    	}
    	return index;
    }
    
    private void downHeap(int i) {
    	boolean hasLeft = hasLeft(i);
    	while(hasLeft) {
    		int largest = left(i);
    		if(compare(heap.get(left(i)), heap.get(right(i))) < 0) 
    			largest  = right(i);
    		if(compare(heap.get(i), heap.get(largest)) < 0) {
    			Entry<K, V> tmp = heap.get(i);
    			heap.set(i, heap.get(largest));
    			heap.set(largest, tmp);
    			i = largest;
    		} else hasLeft = false;		
    	}
    }
    
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
    	buildMaxHeap(heap.size() - 1);
    	return newest;

//    	Entry<K, V> parent = heap.get(parent(heap.indexOf(newest)));
//    	while (compare(newest, parent) > 0) {
//    		Entry<K, V> tmp = newest;
//    		heap.set(heap.indexOf(newest), parent);
//    		heap.set(heap.indexOf(parent), tmp);
//    		newest = parent;
//    	}
    }

    public Entry<K, V> max() {
        // TODO Auto-generated method stub
    	if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    public Entry<K, V> removeMax() {
        // TODO Auto-generated method stub
    	if(heap.isEmpty()) return null;
    	Entry<K, V> toReturn = heap.get(0);
    	heap.set(0, heap.get(heap.size() - 1));
    	heap.remove(heap.size() - 1);
    	downHeap(0);
    	return toReturn;
    }    
    
    /**
     * Method not implemented in this class
     * @returns null
     */
	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		return null;
	}
	
    /**
     * Method not implemented in this class
     * @returns null
     */
	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) { 
		ArrayList<Entry<Integer, String>> list = new ArrayList<>();
		list.add(new PQEntry<>(3, ""));
		list.add(new PQEntry<>(9, ""));
		list.add(new PQEntry<>(7, ""));
		list.add(new PQEntry<>(1, ""));
		list.add(new PQEntry<>(6, ""));
		list.add(new PQEntry<>(12, ""));
		list.add(new PQEntry<>(4, ""));
		MyPriorityHeapFIFO<Integer, String> heap = new MyPriorityHeapFIFO<>(list);
		System.out.print(heap.max().getKey());
		
	}
}
