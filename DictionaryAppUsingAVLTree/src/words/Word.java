package words;

public class Word {
    private String data;
    private String meaning;
    private String example;

    public Word(String data, String meaning, String example) {
        this.data = data;
        this.meaning = meaning;
        this.example = example;
    }
    
    public Word(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return data;
    }
    
    public String details(){
        return data + " : " + meaning + "\n" + "Example: " + example;
    }
    
}
