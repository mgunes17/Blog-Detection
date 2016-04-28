package url_info;

import file_IO.ReadFile;
import java.util.ArrayList;
import java.util.List;

public class KeywordList {
    //dosyadan okuma işlemenin 1 kez yapılması için
    private static List<String> ALL_KEYWORDS = new ArrayList<>(); 
    private ArrayList<Keyword> keywords;
    private static final String FILE_NAME = "keywords.txt";
    
    public KeywordList(){
        keywords = new ArrayList<>();
        if(ALL_KEYWORDS.isEmpty()){          
            ReadFile readFile = new ReadFile(FILE_NAME);
            ALL_KEYWORDS = readFile.read();
        }
 
        for(int i=0; i<ALL_KEYWORDS.size(); i++){
            keywords.add(new Keyword(ALL_KEYWORDS.get(i)));
        }
        
    }
    
    public ArrayList<Keyword> getKeywords(){
        return keywords;
    }
    
    public Keyword getKeyword(int index){
        return keywords.get(index);
    }
}
