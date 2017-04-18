/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Managers.CustomerManager;
import Objects.Customer;
import Objects.Main;
import Managers.DBManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class CustomerView extends JPanel {
    
    JButton home;

    JPanel buttons = new JPanel();
    JPanel list = new JPanel();
    JSONObject j;
    JTextArea jtx;
    DBManager db;
    String key;
    
    public CustomerView(DBManager db){
        opaque();
        j = db.getJSON();
        String listing = "";
        ArrayList<Customer> cus = CustomerManager.all(j);
        for (int c = 0; c < cus.size(); c++) {

            Customer n = cus.get(c);
            String cust = n.viewCustomer();
            listing += cust + "\n";
            
            //System.out.println("key: " + keyStr);

        }
        home = new JButton("Home Screen");
        home.addActionListener(new mainOption());
        display(listing);
        
    }
    
    class mainOption implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            jtx.setText(null);
            Main.reset(j);
        }
    }
    
    class previous implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            jtx.setText(null);
            Main.refresh(new CustomerMenu(key, db));
        }
    }
    
    
    
    public CustomerView(DBManager db, String key){
        opaque();
        this.db = db;
        this.key = key;
        JSONObject job = db.getJSON();
        Customer c = CustomerManager.create(job, key);
        String s = c.viewCustomer();
        home = new JButton("Back");
        home.addActionListener(new previous());
        display(s);
    }
    
    private void display(String listing){
        jtx = new JTextArea();
        jtx.setText(null);
        jtx.append(listing);

        JScrollPane p = new JScrollPane(jtx);
        list.setLayout(new BorderLayout());
        list.add(p, BorderLayout.CENTER);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int h = ((int) Math.round(tk.getScreenSize().getHeight()*0.8));
        int w = ((int) Math.round(tk.getScreenSize().getWidth()*0.8));
        list.setPreferredSize(new Dimension(w, h));
        
        
       // home.setPreferredSize(new Dimension(200,100));
     
        buttons.add(home);
     
        
        setLayout(new BorderLayout());
        add(list, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        
        Main.refresh(this);
    }
    
    private void opaque(){
        setOpaque(false);
        list.setOpaque(false);
        buttons.setOpaque(false);
    }
    
    
 
}
