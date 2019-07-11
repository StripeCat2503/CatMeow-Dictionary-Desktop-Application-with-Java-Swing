package app;

import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class WordListModel implements ListModel<String>{

    private ArrayList<String> list = new ArrayList<>();
    
    public WordListModel(ArrayList<String> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }  

    @Override
    public String getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }
    
    public ArrayList<String> getList(){
        return list;
    }

}
