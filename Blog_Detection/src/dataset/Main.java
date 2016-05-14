package dataset;

import file_IO.WriteFile;
import url_info.UrlList;

public class Main {
    public static void main(String args[]){
        
        CreateUrlLists cul = new CreateUrlLists();
        cul.writeUrlIntoFile("https://moz.com/top500", false);       
        cul.writeUrlIntoFile("http://www.cellarer.com/best-cooking-blogs", true);
          
        
        UrlList urls = new UrlList(true);
        urls.createFiles();
        urls.readSourceCode();
//        urls.countUrlKeyword();
//        WriteFile wf = new WriteFile("raw_dataset.txt");
//        wf.writeKeywords(urls, true);
        
        urls = new UrlList(false);
        urls.createFiles();
        urls.readSourceCode();
//        urls.countUrlKeyword();
//        wf.writeKeywords(urls, false);
    }

}
