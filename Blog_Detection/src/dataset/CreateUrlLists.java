package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import url_info.UrlList;

public class CreateUrlLists {
    private final String blogFileName = "blogs.txt";
    private final String notBlogFileName = "notblogs.txt";
    
    public void writeUrlIntoFile(String urlName, boolean isBlog){
        File file;
        
        if(isBlog)
            file = new File(blogFileName);
        else
            file = new File(notBlogFileName);
        
        try{
            String line;
            String parsedUrl;
            BufferedReader in = openConnection(urlName);
            PrintWriter pw = new PrintWriter(new FileOutputStream(file), true);
            
            while ((line = in.readLine()) != null){
                parsedUrl = parseUrl(line);
                if(!parsedUrl.equals("http://"))
                    pw.println(parsedUrl);    
            }
            pw.flush();
        }
        catch(FileNotFoundException fe){
            System.err.println(fe);
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }  
        
    }
    
    
    private String parseUrl(String line){
        String urlName = "http://";
        String template = "<a href=\"http://";
        
        if(line.contains(template)){
            int i = line.indexOf(template);
            i = i + 16;
            while(line.charAt(i) != '"'){
                urlName = urlName + line.charAt(i);
                i++;
//                System.err.println(urlName);
            }
        }
        
        return urlName;
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
    
    
    
    
    
}
