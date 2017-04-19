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

import java.util.Scanner;

public class Redemption {
    
    int p;
    double t;
    boolean x;
    double disc=0;
    
    public Redemption(int points, double totPrice){
    
    p = points;
    t = totPrice;
    
      Rewards k = new Rewards("10%", "Discount", 0.10);
      Rewards u = new Rewards("20%", "Discount", 0.20);
      Rewards l = new Rewards("100%", "Free Purchase", 1.00);
      
    
      
      if ((t*l.getPoints() <= p && t > 2000)){
          
            Scanner decision = new Scanner(System.in);
            System.out.print("You are elegible for a free purchase,20% discount or 10%discount, would you like to redeem?");
            String item = decision.nextLine();
            
            if (item.equals("yes")){ /*GUI to represent selection*/
                
                System.out.print("Which would u like to redeem");
                String item2 = decision.nextLine();
                if (item2.equals("10%")){
                    
                 disc += (t*k.getPoints());
                 x = true;
                }
                if (item2.equals("20%")){
                    
                 disc += (t*u.getPoints());
                 x = true;
                }
                if (item2.equals("free")){
                    
                 disc += (t*l.getPoints());
                 x = true;
                }
            }
                
            }
      if ((t*u.getPoints() <= p && t > 1000 && t<2000)){
          
            Scanner decision = new Scanner(System.in);
            System.out.print("You are elegible for a 20% discount or 10%discount, would you like to redeem?");
            String item = decision.nextLine();
            
            if (item.equals("yes")){ /*GUI to represent selection*/
                
                System.out.print("Which would u like to redeem");
                String item2 = decision.nextLine();
                
                if (item2.equals("10%")){
                    
                 disc += (t*k.getPoints());
                 x = true;
                }
                if (item2.equals("20%")){
                    
                 disc += (t*u.getPoints());
                 x = true;
                }
                
            }
                
        }
      
        if ((t*k.getPoints() <= p && t > 5000 && t<1000)){
          
            Scanner decision = new Scanner(System.in);
            System.out.print("You are elegible for a 10%discount, would you like to redeem?");
            String item = decision.nextLine();
            
            if (item.equals("yes")){ /*GUI to represent selection*/
                
                disc += (t*k.getPoints());
                 x = true;
            }
        }
        
        if (x == false){
            System.out.println("Redemtion is not possible");
            
        }
      
      
    }
    
    public double getDisc(){
        return disc;
    }
    
}
