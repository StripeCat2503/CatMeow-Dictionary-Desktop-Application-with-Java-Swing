package avltree;

import java.util.ArrayList;

public class AVLTree<T> {
    // Java program for insertion in AVL Tree 

    protected Node<T> root;
    protected ArrayList<Node<T>> nodeList = new ArrayList<>();

    // A utility function to get the height of the tree 
    private int height(Node<T> n) {
        if (n == null) {
            return 0;
        }

        return n.getHeight();
    }

    // A utility function to get maximum of two integers 
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    private Node rightRotate(Node<T> y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        // Perform rotation 
        x.setRight(y);
        y.setLeft(T2);

        // Update heights 
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new root 
        return x;
    }

    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    private Node leftRotate(Node<T> x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        // Perform rotation 
        y.setLeft(x);
        x.setRight(T2);

        //  Update heights 
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        // Return new root 
        return y;
    }

    // Get Balance factor of node N 
    int getBalance(Node<T> n) {
        if (n == null) {
            return 0;
        }

        return height(n.getLeft()) - height(n.getRight());
    }

    protected Node<T> insert(Node<T> node, T obj) {
        //obj < node.getObj()

        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new Node<>(obj));
        }

        if (obj.toString().compareTo(node.getObj().toString()) < 0) {
            node.setLeft(insert(node.getLeft(), obj));
        } else if (obj.toString().compareTo(node.getObj().toString()) > 0) {
            node.setRight(insert(node.getRight(), obj));
        } else // Duplicate keys not allowed 
        {
            return node;
        }

        /* 2. Update height of this ancestor node */
        node.setHeight(1 + max(height(node.getLeft()),
                height(node.getRight())));

        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && obj.toString().compareTo(node.getLeft().getObj().toString()) < 0) {
            return rightRotate(node);
        }

        // Right Right Case 
        if (balance < -1 && obj.toString().compareTo(node.getRight().getObj().toString()) > 0) {
            return leftRotate(node);
        }

        // Left Right Case 
        if (balance > 1 && obj.toString().compareTo(node.getLeft().getObj().toString()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case 
        if (balance < -1 && obj.toString().compareTo(node.getRight().getObj().toString()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private T minValue(Node<T> node) {
        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getObj();
    }

    protected Node<T> deleteNode(Node<T> node, T obj) {
        /* 1. Perform the normal BST */
        if (node == null) {
            return node;
        }
        if (obj.toString().compareTo(node.getObj().toString()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), obj));
        } else if (obj.toString().compareTo(node.getObj().toString()) > 0) {
            node.setRight(deleteNode(node.getRight(), obj));
        } else {
            // node with no leaf nodes
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                // node with one node (no left node)
                return node.getRight();
            } else if (node.getRight() == null) {
                // node with one node (no right node)
                return node.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                T minValue = minValue(node.getRight());
                node.setObj(minValue);
                node.setRight(deleteNode(node.getRight(), minValue));

            }
            /* 2. Update height of this ancestor node */
            node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
            /* 3. Get the balance factor of this ancestor
                node to check whether this node became
                unbalanced 
             */
            int balance = getBalance(node);
            // If this node becomes unbalanced, then there
            // are 4 cases 

            // Left Left Case
            if (balance > 1 && getBalance(node.getLeft()) >= 0) {
                return rightRotate(node);
            }
            // Left Right Case
            if (balance > 1 && getBalance(node.getLeft()) < 0) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
            // Right Right Case
            if (balance < -1 && getBalance(node.getRight()) <= 0) {
                return leftRotate(node);
            }
            // Right Left Case
            if (balance < -1 && getBalance(node.getRight()) > 0) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        return node;
    }

    protected Node<T> search(Node<T> node, T obj) {
        if (node == null) {
            return null;
        }
        if (node.getObj().toString().equals(obj.toString())) {
            return node;
        }
        if (node.getObj().toString().compareTo(obj.toString()) > 0) {
            return search(node.getLeft(), obj);
        } else {
            return search(node.getRight(), obj);
        }
    }
    
    public void preOrder(Node<T> node) {       
     
        if (node != null) { 
            nodeList.add(node); 
            
            preOrder(node.getLeft()); 
            preOrder(node.getRight()); 
        }      
    } 
}
