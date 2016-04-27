package url_info;

public class Keyword {
    private String name;
    private int count;

    public Keyword(){
        //non-args constructor
    }
    
    public Keyword(String name, int count){
        this.name = name;
        this.count = count;
    }
    
    public Keyword(String name){
        this.name = name;
    }
    
    //sayma işleminde kullanılır
    public void upCount(){
        count++;
    }
    
    //getter-setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
