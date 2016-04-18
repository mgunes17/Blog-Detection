/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httprequest;

/**
 *
 * @author must
 */
public class Keyword {
    private String name;
    private int count;

    public Keyword(String name, int count){
        this.name = name;
        this.count = count;
    }
    
    public Keyword(String name){
        this.name = name;
    }
    
    //getter-setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
