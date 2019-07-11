package avltree;

public class Node<T> {

    private T obj;
    private int height;
    private Node<T> left, right;

    public Node(T obj) {
        this.obj = obj;
        height = 1;
    }

    public int getHeight() {
        return height;
    }
    
    public Node<T> getLeft(){
        return left;
    }
    
    public Node<T> getRight(){
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
    
    
}
