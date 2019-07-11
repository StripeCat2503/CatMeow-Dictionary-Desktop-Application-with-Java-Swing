package words;

import avltree.AVLTree;
import avltree.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dictionary extends AVLTree<Word> {

    private String fileName;

    public Dictionary(String fileName) {
        this.fileName = fileName;
        loadData();
        preOrder(root);
    }

    public void addWord(Word w) {
        this.root = insert(this.root, w);
    }

    public void removeWord(Word w) {
        deleteNode(this.root, w);
    }

    public Word searchWord(Word searchWord) {
        Node<Word> w = search(this.root, searchWord);
        return w.getObj();
    }
    
    public boolean isDuplicated(Word word){
        Node<Word> w = search(this.root, word);
        if(w != null){
            return true;
        }
        return false;
    }

    public void saveToFile() {
        File f = new File(fileName);
        if(!f.exists()){
            return;
        }
        try {
            
            if(nodeList.isEmpty()) preOrder(root);
            
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (int i = 0; i < nodeList.size(); i++) {
                Node<Word> node = nodeList.get(i);
                String word = node.getObj().getData();
                String meaning = node.getObj().getMeaning();
                String ex = node.getObj().getExample();
                pw.println(word + ";" + meaning + ";" + ex);
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Error while writing to file");
        }
        
    }

    public void loadData() {
        
        File f = new File(fileName);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            StringTokenizer stk;
            while((line = br.readLine()) != null){
                stk = new StringTokenizer(line, ";");
                String word = stk.nextToken();
                String meaning = stk.nextToken();
                String ex = stk.nextToken();
                Word w = new Word(word, meaning, ex);
                this.addWord(w);
            }
            br.close();
        } catch (IOException e) {
        }
    }

    public Node<Word> getRoot() {
        return root;
    }

    public ArrayList<Node<Word>> getNodeList() {
        return nodeList;
    }
    
    public ArrayList<String> searchWords(String searchKey){
        int count = searchKey.length();
        ArrayList<String> words = new ArrayList<>();
    
        for (int i = 0; i < nodeList.size(); i++) {
            Node<Word> node = nodeList.get(i);
            String word = node.getObj().getData();
            if(count > word.length()){
                continue;
            }
            if(searchKey.equalsIgnoreCase(word.substring(0, count))){
                words.add(word);
            }
        }
        return words;
    }
    
}
