package file_IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import url_info.KeywordList;
import url_info.Url;

public class WriteFile {
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    
    public WriteFile(){
        file = new File("raw_dataset.txt");
    }
    
    public void write(ArrayList<Url> urlList){
        try{
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            KeywordList keywords;
            
            //keyword id falan tek seferlik yazdırma işi
            
            //her bir url icin
            for(int i=0; i<urlList.size(); i++){
                //bufferedWriter.write(urlList.get(i).getUrlName()+"\t\t\t");
                bufferedWriter.write(i+"\t\t");
                bufferedWriter.write(urlList.get(i).getContentLength()+"\t\t\t");
                
                keywords = urlList.get(i).getKeywordList();
                
                //her url in keyword listesi icin
                for(int j=0; j<keywords.getKeywords().size(); j++){
                   bufferedWriter.write(keywords.getKeyword(j).getCount()+"\t\t");
                }
                
                /*bufferedWriter.write(+"\t");
                bufferedWriter.write(+"\t");
                bufferedWriter.write(+"\t");
                bufferedWriter.write(+"\t");*/
                
                bufferedWriter.write("\n");
            }
            
            
            bufferedWriter.flush();
            
            bufferedWriter.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
        
    }
}
