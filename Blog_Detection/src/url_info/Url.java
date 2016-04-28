package url_info;

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
    private int externalLinkCount = 0; //sayfanın dışarıya veriği link sayısı
    private int internalLinkCount = 0; //sayfanın aynı domaine verdiği link sayısı

    
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
        
        countHyperLink();
                
    }
    
    //içeriye-dışarıya verilen link sayıları
    public void countHyperLink(){
        for(int i=0; i<contentSplitSpace.length; i++){
            if(contentSplitSpace[i].contains("href")){
                if(
                        contentSplitSpace[i-1].contains("<a") && 
                        !contentSplitSpace[i].contains("http")){

                    internalLinkCount++;
                }
                else{
                    externalLinkCount++;
                }
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
    
    public int getExternalLinkCount() {
        return externalLinkCount;
    }

    public void setExternalLinkCount(int externalLinkCount) {
        this.externalLinkCount = externalLinkCount;
    }

    public int getInternalLinkCount() {
        return internalLinkCount;
    }

    public void setInternalLinkCount(int internalLinkCount) {
        this.internalLinkCount = internalLinkCount;
    }
}
