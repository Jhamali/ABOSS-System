/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Nish1
 */

public class Collection {
    
    private  int points;
    
    public Collection(float price){
    
    int con = convertPoints(price);
    points = con/10;
    if (con>=1000)
        points+=100;    
    }
    
    public int convertPoints(float price){
        return (int) Math.round(price);
    }
    
    public int getPoints(){
        return points;
    }    
}
