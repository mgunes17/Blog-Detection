package url_info;

import file_IO.ReadFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Url {
    private String urlName;
    private String content;
    private String[] contentSplitSpace;
    private KeywordList keywordList;
    private int contentLength;
    private int id;
    
    //constructor metotlar
    public Url(String name, int id){
        urlName = name;
        this.id = id;
        keywordList = new KeywordList();
    }

    public Url(String name){
        urlName = name;
        keywordList = new KeywordList();
    }
    
    //keywordleri say
    public void countKeywords(){
        contentSplitSpace = content.split(" ");
        for(Keyword keyword : keywordList.getKeywords()){
            for(String word : contentSplitSpace){
                if(word.contains(keyword.getName()))
                    keyword.upCount();
            }
        }
    }
    
    //dosyadan url kaynak kodunu oku
    public void readContent(){
        File file = new File("httpResponse/"+id+".txt");
        char data[] = new char[(int)file.length()];
        
        try{       
            FileReader r = new FileReader(file);
            r.read(data);
        
            content = new String(data);
            System.out.println(content.length());
        }
        catch(FileNotFoundException e){
            System.err.println(e);
        }
        catch(IOException e){
            System.err.println(e);
        }
        
        //size ı hesapla
        contentLength = content.length();
    }
    
    //getter-setter metotları
    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public KeywordList getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(KeywordList keywordList) {
        this.keywordList = keywordList;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }
    
    public int getId(){
        return id;
    }
}
