package dataset;

import url_info.UrlList;

public class Main {
    public static void main(String args[]){

        UrlList urls = new UrlList();
        urls.createFiles();
        urls.readSourceCode();
        urls.countUrlKeyword();
        
        //bir metot yaz string ve keywordu alıcak içinde kaç tane olduğunu bulacak
    }

}
