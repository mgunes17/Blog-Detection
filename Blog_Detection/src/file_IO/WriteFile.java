package file_IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import url_info.Keyword;
import url_info.KeywordList;
import url_info.Url;
import url_info.UrlList;

public class WriteFile {
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    
    public WriteFile(String fileName){
        file = new File(fileName);
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
    
    public void writeKeywords(UrlList urlList ){
        try{
            if (!file.exists()) {
                System.out.println("File not found");
            }
            
            PrintWriter writer = new PrintWriter(file);
            // writing the key names on the 1st row
            writer.print("Content_Size\tInternal_Link\tExternal_Link\t");
            List<Keyword> keyNames = urlList.getUrl(0).getKeywordList().getKeywords();
            for(Keyword k : keyNames){ 
                writer.print(k.getName() + " \t");
            }
            writer.println("");
            
            // writing the count of the keys
            for(int i=0; i<urlList.getUrlList().size(); i++){
                List<Keyword> keywords = urlList.getUrl(i).getKeywordList().getKeywords();  
                writer.print(urlList.getUrl(i).getContentLength() + "\t\t" + 
                             urlList.getUrl(i).getInternalLinkCount() + "\t\t" +
                             urlList.getUrl(i).getExternalLinkCount()+ "\t\t");
                
                for(Keyword k : keywords){
                    writer.print(k.getCount() + " \t");
                }
                writer.println();
            }
            
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }
}
