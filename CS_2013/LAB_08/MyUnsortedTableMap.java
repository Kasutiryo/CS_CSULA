package LAB_08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import net.datastructures.AbstractMap;
import net.datastructures.Entry;

public class MyUnsortedTableMap<K,V> extends AbstractMap<K,V>{

    protected ArrayList<MapEntry<K,V>> table = new ArrayList<>();   
    
    /**
     * Searches for the given key and returns the entry associated with the key, 
     * otherwise, returns null.
     * @param key
     * @return returns entry associated with key (null if key is not found)
     */
    public MapEntry<K,V> search(K key) {
    	for(MapEntry<K,V> item: table) {
    		if(item.getKey().equals(key)) {
    			return item;
    		}
    	}
    	return null;
    }
    
    public boolean contains(K key) {
    	for(MapEntry<K,V> item: table) {
    		if(item.getKey().equals(key))
    			return true;
    	}
    	return false;
    }
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return table.size();
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
    	if(table.isEmpty()) return null;
    	MapEntry<K,V> item = search(key);
    	return item.getValue();
    }

    @Override
    public V put(K key, V value) {
        // TODO Auto-generated method stub
    	MapEntry<K,V> item = search(key);
    	if(item != null) {
    		V oldValue = item.getValue();
    		table.set(table.indexOf(item), new MapEntry<K,V>(key, value));
    		return oldValue;	
    	} else {
    		table.add(new MapEntry<K,V>(key, value));
    		return null; 
        }
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
    	if(table.isEmpty()) return null;
    	MapEntry<K,V> item = search(key);
    	if(item != null) {
        	V removedValue = item.getValue();
        	table.remove(item);
        	return removedValue;
    	} else
    		return null;
    }
    
    //---------------- nested EntryIterator class ---------------
    private class EntryIterator implements Iterator<Entry<K,V>> {

    	int i = 0;
    	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(i < size()) return true;
			return false;
		}

		@Override
		public Entry<K, V> next() {
			// TODO Auto-generated method stub
			if(i == size()) throw new NoSuchElementException();
			return table.get(i++);
		}
    	
    } //------------- end of nested EntryIterator class ---------
   
    //---------------- nested EntryIterable class ---------------
    private class EntryIterable implements Iterable<Entry<K,V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new EntryIterator();
		}
    	
    } //------------- end of nested EntryIterable class ---------
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return new EntryIterable();
    }

}
