package LAB_05;

import net.datastructures.*;

public class DArrayStack<E> implements Stack<E> {
    
    private net.datastructures.ArrayList<E> data;
    
    DArrayStack(){
        data = new net.datastructures.ArrayList<E>();
    }

    DArrayStack(int capacity){
        data = new net.datastructures.ArrayList<E>(capacity);
    }
    
    @Override
    public void push(E e) {
        // TODO Auto-generated method stub
        data.add(0, e);
    }

    @Override
    public E top() {
        // TODO Auto-generated method stub
        return data.get(0);
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        E tmp = data.get(0);
        data.remove(0);
        return tmp;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return data.isEmpty();
    }

}