package avltree;

import words.Word;

public class TestTree {
    public static void main(String[] args) {
        AVLTree<Word> tree = new AVLTree<>();
        tree.root = tree.insert(tree.root, new Word("Banana", "Qua chuoi", "I eat a banana"));
        tree.root = tree.insert(tree.root, new Word("Great", "Tuyet voi", "Today is a great day!"));
        tree.root = tree.insert(tree.root, new Word("Computer", "May vi tinh", "I bought a computer yesterday"));
      
        Node<Word> w = tree.search(tree.root, new Word("Banana"));
        if(w != null){
            System.out.println("Word found!");
            System.out.println(w.getObj().getExample());
        }
        else{
            System.out.println("Word not found");
        }
        
        //tree.preOrder(tree.root);
        
    }
}
