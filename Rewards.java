/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system;

/**
 *
 * @author Nish1
 */
public class Rewards {
    
    private String nme;
    private String typ;
    private double poi;
     
    
    public Rewards(String name, String type, double points){
      
       nme = name; 
       typ = type;
       poi = points;
       
        
        
    }
    
    public String getName(){
        return nme;
    }
    
    public String getType(){
        return typ;
    }
    
    public double getPoints(){
        return poi;
    }
    
  
    
    public String toString(){
    String s;
    
    s = "\nName: " + getName() + "\tType: " + getType() + "\tPercentage of Purchase Required: " + getPoints();
    return s;
    }

    
   
    
}
