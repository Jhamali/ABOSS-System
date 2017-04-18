package GUI;

import Adapters.POSAdapter;
import Managers.DBManager;
import Objects.Collection;
import Objects.Main;
import static Objects.Main.f;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dubze
 */
public class CustomerMenu extends JPanel {

    String id;
    DBManager db;

    public CustomerMenu(String uniqueID, DBManager data) {

        id = uniqueID;
        db = data;
        
        setOpaque(false);

        setLayout(new GridLayout(10, 1));

        JLabel cusL = new JLabel("What would the customer like to do?",SwingConstants.CENTER);
        cusL.setFont(new Font("Helvetica", Font.ITALIC, 50));

        JPanel lab = new JPanel();
        lab.setOpaque(false);
        lab.setLayout(new GridLayout(1,1));
        cusL.setForeground(Color.WHITE);
        
        lab.add(cusL);

        JPanel vP = new JPanel();
        vP.setOpaque(false);
        vP.setLayout(new GridLayout(1,4));
        JButton v = new JButton("View Customer Profile");
        v.setBackground(Color.BLACK);
        v.setForeground(Color.WHITE);
        v.setFont(new Font("Arial", Font.BOLD, 30));
        v.addActionListener(new viewer());
        v.setPreferredSize(new Dimension(200, 100));
        vP.add(v);

       
        JButton r = new JButton("Redeem Reward");
        r.addActionListener(new rewOption());
        r.setPreferredSize(new Dimension(200, 100));
        r.setBackground(Color.BLACK);
        r.setForeground(Color.WHITE);
        r.setFont(new Font("Arial", Font.BOLD, 30));
        vP.add(r);

        
        JButton p = new JButton("Add Points");
        p.addActionListener(new addPoints());
        p.setPreferredSize(new Dimension(200, 100));
        p.setBackground(Color.BLACK);
        p.setForeground(Color.WHITE);
        p.setFont(new Font("Arial", Font.BOLD, 30));
        vP.add(p);

        JButton back = new JButton("Home Screen");
        back.setPreferredSize(new Dimension(200, 100));
        back.addActionListener(new mainOption());
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 30));
        vP.add(back);

        add(lab);
        add(vP);
        //add(rP);
        //add(point);
        //add(home);

    }

    class rewOption implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            f.getContentPane().removeAll();
            f.getContentPane().add(new Rewards());
            f.validate();
            f.setVisible(true);
        }
    }

    class mainOption implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Main.reset(db.getJSON());
        }
    }

    void reload() {
        Main.refresh(this);
    }

    class addPoints implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            try {
                String t = POSAdapter.getTotal();
               
                float tot = Float.parseFloat(t);
                if (tot>100)
                    db.updatePoints(id, new Collection(tot));
            } catch (IOException ex) {
                Logger.getLogger(CustomerMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class viewer implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Main.refresh(new CustomerView(db,id));
        }
    }
    
    

 

}
