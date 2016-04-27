package url_info;

import file_IO.ReadFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlList {
    private static ArrayList<String> ALL_URLS = new ArrayList<>(); 
    private final ArrayList<Url> urlList; 
    private static final String FILE_NAME = "urls.txt";
    
    
    public UrlList(){
        urlList = new ArrayList<>();
        
        if(ALL_URLS.isEmpty()){
            ReadFile readFile = new ReadFile(FILE_NAME);
            ALL_URLS = readFile.read();
        }
        
        for(int i=0; i<ALL_URLS.size(); i++){
            urlList.add(new Url(ALL_URLS.get(i),i));
        }
    }
    
    //listedeki tüm url lerin kaynak kodlarını oku
    public void readSourceCode(){
        for(int i=0; i<urlList.size(); i++){
            urlList.get(i).readContent();
        }
    }
    
    //listedeki tüm urller için keywordleri say
    public void countUrlKeyword(){
        for(int i=0; i<urlList.size(); i++){
            urlList.get(i).countKeywords();
        }
    }
    
    public void createFiles(){
        String inputLine;
        File file;
        PrintWriter writer;
        BufferedReader in;
        
        for(int i=0; i<urlList.size(); i++){
            try{
                in = openConnection(urlList.get(i).getUrlName());
                //Okunan url için bir dosya oluştur
                file = new File(String.valueOf(
                        "httpResponse/"+urlList.get(i).getId())+".txt");
                file.createNewFile();
                writer = new PrintWriter(file);

                //url i adına oluşturulan dosyaya yazdır
                while ((inputLine = in.readLine()) != null){
                    writer.println(inputLine);         
                }
            } 
            catch(IOException e){
                System.err.println(e);
            }
        }
    }
    
    private BufferedReader openConnection(String urlName){
        URL url;
        URLConnection urlConnection;
        BufferedReader in = null;
        
        try {
            //Bağlantı için URL nesnesi oluştur
            url = new URL(urlName);
             //Bağlantıyı aç
            urlConnection = url.openConnection();
            //Network üzerinden okuma yapmak için in nesnesini kullan
            in = new BufferedReader(new InputStreamReader(
                                          urlConnection.getInputStream()));
        } 
        catch (MalformedURLException ex) {
            Logger.getLogger(UrlList.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException e){
            System.err.println(e);
        }
        
        return in;
    }
    
    public Url getUrl(int index){
        return urlList.get(index);
    }
    
    public ArrayList<Url> getUrlList() {
        return urlList;
    }

}
