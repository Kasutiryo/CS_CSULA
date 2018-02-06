/*
 * Consider a tree T sorting 1,000 entries. What is the worst-case height
 * of T in each of the following cases?
 * 
 * 1. 1,000 
 * 2. LOG(1000)
 * 3. 
 * 4.
 * 5. 1000*LOG(1000)
 * 
 */

package LAB_09;

public class BST<E extends Comparable<E>> implements Tree<E>{
    private TreeNode<E> root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    
    public BST(E[] list){
        for(int i = 0; i < list.length; i++){
            insert(list[i]);
        }
    }
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size==0;
    }

    @Override
    public boolean search(E e) {
        // TODO Auto-generated method stub
    	return search(e, root);

    }

    private boolean search(E e, TreeNode<E> node) {
    	if(node == null)
    		return false;
    	else if(e.compareTo(node.element) < 0)
    		return search(e, node.left);
    	else if(e.equals(node.element))
    		return true;
    	else
    		return search(e, node.right);
    }
    
    @Override
    public TreeNode<E> tree_minimum() {
        // TODO Auto-generated method stub
        return tree_minimum(root);
    }
    
    private TreeNode<E> tree_minimum(TreeNode<E> min) {
    	
    	if(min.left == null) {
    		return min;
    	} else
    		return tree_minimum(min.left);
    }

    @Override
    public TreeNode<E> tree_maximum() {
        // TODO Auto-generated method stub
        return tree_maximum(root);
    }

    private TreeNode<E> tree_maximum(TreeNode<E> max) {
    	
    	if(max.right == null) 
    		return max;
    	else
    		return tree_maximum(max.right);
    }
    
    @Override
    public int height() {
        // TODO Auto-generated method stub
    	return height(root);
    }
    
    private int height(TreeNode<E> node) {
    	if (node == null) 
    		return 0;
    	else {
    		return 1 + Math.max(height(node.left), height(node.right));
    		}
    }
    
    private TreeNode<E> breadthFirst(TreeNode<E> node) {
	  if(node.left == null && node.right == null) {
		  System.out.print(node.element); // for debugging use
		  return node;
	  }
	  breadthFirst(node.left);
	  breadthFirst(node.right);
	  return node;
    }
    
    @Override
    public boolean insert(E e) {
        // TODO Auto-generated method stub
    	if(size() == 0) {
    		root = new TreeNode<E>(e);
    		size++;
    		return true;
    	}
    	TreeNode<E> parent = findInsertPoint(e, root, null);
    	if(e.compareTo(parent.element) < 0) {
    		parent.left = new TreeNode<E>(e);
    		size++;
    		return true;
    	} else if(e.compareTo(parent.element) > 0){
    		parent.right = new TreeNode<E>(e);
    		size++;
    		return true;
    	}
    	throw new IllegalArgumentException("Invalid Entry");
   
    }
    
    private TreeNode<E> findInsertPoint(E e, TreeNode<E> node, TreeNode<E> parent) {
    	
    	if(node == null) {
    		return parent;
    	} else if(e.compareTo(node.element) < 0) {
    		return findInsertPoint(e, node.left, node); 
    	}
    		return findInsertPoint(e, node.right, node);
    	
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(TreeNode<E> root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.element + "  ");
            inOrder(root.right);
        }
    }
    
    @Override
    public boolean delete(E e) {
        // TODO Auto-generated method stub
        TreeNode<E> curr = root;
        while(curr!= null){
            if(e.compareTo(curr.element)<0){
                curr = curr.left;
            }else if (e.compareTo(curr.element)>0){
                curr = curr.right;
            }else{
                break; // we found the element to delete
            }
        }
        
        if(curr == null){
            return false; // we did not found the element
        }else{
            
            if(curr.left == null){
                transplant(curr, curr.right);
            }else if(curr.right == null){
                transplant(curr, curr.left);
            }else{
                TreeNode<E> min = minimum(curr);
                if(min.parent != curr){
                    transplant(min, min.right);
                    min.right = curr.right;
                    min.right.parent = min;
                }
                transplant(curr, min);
                min.left = curr.left;
                min.left.parent = min;
            }
            return true;
        }
    }
    
    public TreeNode<E> minimum(TreeNode<E> root){
        while(root.left != null){
            root = root.left;
        }
        return root;
        
    }
    
    private void transplant(TreeNode<E> u, TreeNode<E> v){
        if(u.parent == null){
            root = v;
        }else if (u == u.parent.left){
            u.parent.left = v;
        }else {
            u.parent.right = v;
        }
        if (v != null){
            v.parent = u.parent;
        }
    }

    public static void main(String[] args) {
    	Integer[] list = new Integer[10];
    	list[0] = 6;
    	list[1] = 5;
    	list[2] = 10;
    	list[3] = 4;
    	list[4] = 7;
    	list[5] = 3;
    	list[6] = 1;
    	list[7] = 2;
    	list[8] = 12;
    	list[9] = 9;
    	BST<Integer> tree = new BST<>(list);
    	tree.inOrder();
    	tree.insert(8);
    	System.out.println(tree.height());
    	tree.inOrder();

    }
    

}

interface Tree<E> {
	public int size();
	public int height();
	public boolean isEmpty();
	public boolean search(E e);
	public boolean insert(E e);
	public boolean delete(E e);
	public TreeNode<E> tree_minimum();
	public TreeNode<E> tree_maximum();
}

class TreeNode<E>{
	protected E element;
	protected TreeNode<E> parent;
	protected TreeNode<E> left;
	protected TreeNode<E> right;

	public TreeNode(E element){
		this.element = element;
		left = null;
		right = null;
	}
}
