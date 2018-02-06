package LAB_08;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import net.datastructures.*;

public class MyHashTable<K,V> extends AbstractHashMap<K,V>{
	
	protected ArrayList<LinkedList<MapEntry<K,V>>> table;

	public MyHashTable() {
		super();
	} 
	
	//---------------- nested EntryIterator class ---------------
    private class EntryIterator implements Iterator<LinkedList<MapEntry<K,V>>> {

    	int i = 0;
    	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(i < size()) return true;
			return false;
		}

		@Override
		public LinkedList<MapEntry<K,V>> next() {
			// TODO Auto-generated method stub
			if(i == size()) throw new NoSuchElementException();
			return table.get(i++);
		}
    	
    } //------------- end of nested EntryIterator class ---------
   
    //---------------- nested EntryIterable class ---------------
    private class EntryIterable implements Iterable<LinkedList<MapEntry<K,V>>> {

		@Override
		public Iterator<LinkedList<MapEntry<K, V>>> iterator() {
			// TODO Auto-generated method stub
			return new EntryIterator();
		}
    	
    } //------------- end of nested EntryIterable class ---------
    
	@Override
	public Iterable entrySet() {
		// TODO Auto-generated method stub
		return new EntryIterable();
	}

    /**
     * Searches the bucket found using hash code h, for a MapEntry with matching
     * key, and returns the MapEntry<K,V>.
     * @param h HashCode
     * @param k	Key
     * @return MapEntry<K,V> associated with Object k in bucket h.
     */
    private MapEntry<K,V> contains(int h, K k) {
    	
		LinkedList<MapEntry<K,V>> list = table.get(h);
		Iterator<MapEntry<K,V>> iter = list.iterator();
		
		while(iter.hasNext()) {
			if(iter.next().getKey().equals(k))
				return iter.next();
		}
    	return null;
    }
	
    /**
     * Adds new MapEntry into the LinkedList (bucket) given by hash code h, and returns the new MapEntry.
     * @param h HashCode
     * @param k	Key
     * @param v Value
     * @return returns MapEntry that was added to the end of the list.
     */
    private MapEntry<K,V> addLast(int h, K k, V v) {
		table.add(h, new LinkedList<MapEntry<K,V>>());
		table.get(h).add(new MapEntry<>(k,v));
		return table.get(h).getLast();
    }
    

	@Override
	protected void createTable() {
		// TODO Auto-generated method stub
		table = new ArrayList<>(capacity);
	}

	@Override
	protected V bucketGet(int h, K k) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		MapEntry<K,V> item = contains(h,k);
		if(item != null) 
			return item.getValue();
		else
			throw new IllegalArgumentException("A MapEntry with a matching key, k, was not found.");
	}

	@Override
	protected V bucketPut(int h, K k, V v) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return addLast(h, k ,v).getValue();
		} else {
			MapEntry<K,V> item = contains(h, k);
			if(item != null) 
				return item.getValue();
			else {
				return addLast(h, k, v).getValue();
			}
		}
	}

	@Override
	protected V bucketRemove(int h, K k) {
		// TODO Auto-generated method stub
		MapEntry<K,V> item = contains(h, k);
		table.get(h).remove(item);
		return item.getValue();
	}
	
	@Override
	public boolean isEmpty() {
		Iterator<LinkedList<MapEntry<K,V>>> iter = table.iterator();
		while(iter.hasNext()) {
			if(!iter.next().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
