
package url_info;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyThread extends Thread{
    private Url url;
    
    public MyThread(Url url){
        this.url = url;
    }
    public void run(){
        String inputLine;
        File file;
        PrintWriter writer;
        BufferedReader in;
        int count = 0;
            try{
                in = openConnection(url.getUrlName());
                if(in != null){
                    count++;
                    System.out.println(url.getUrlName()+" "+url.getId()+" nolu url için bağlantı açıldı..." + count);
                    //Okunan url için bir dosya oluştur
                    file = new File(String.valueOf(
                            "httpResponse/"+url.getId())+".txt");
                    file.createNewFile();
                    writer = new PrintWriter(file);

                    //url i adına oluşturulan dosyaya yazdır
                    while ((inputLine = in.readLine()) != null){
                        writer.println(inputLine);         
                    }
                }
                
            } 
            catch(IOException e){
                System.err.println(e);
            }
    }
    
    private  BufferedReader openConnection(String urlName){
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
            //Logger.getLogger(UrlList.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return null;
        }
        catch(IOException e){
            System.err.println(e);
        }
        
        return in;
    }
}
