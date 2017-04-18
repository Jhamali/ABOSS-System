/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author dubze
 */
public class Rewards extends JPanel{
    
    public Rewards(){
        setOpaque(false);
        setLayout(new GridLayout(10,1));
        
        JLabel rewL = new JLabel("Choose the type of reward the customer would like to redeem", SwingConstants.CENTER);
        rewL.setForeground(Color.WHITE);
        rewL.setFont(new Font("Helvetica", Font.ITALIC,50));
        
        JPanel rew = new JPanel();
        rew.setLayout(new GridLayout(1,1));
        rew.setOpaque(false);
        rew.add(rewL);
        
        JPanel dis = new JPanel();
        dis.setOpaque(false);
        dis.setLayout(new GridLayout(1,2));
        JButton d = new JButton("Discounts");
        d.setPreferredSize(new Dimension(200,100));
        d.setBackground(Color.BLACK);
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Arial", Font.BOLD, 30));
        dis.add(d);
        
        JPanel free = new JPanel();
        free.setOpaque(false);
        JButton f = new JButton("Free Purchase");
        f.setBackground(Color.BLACK);
        f.setForeground(Color.WHITE);
        f.setFont(new Font("Arial", Font.BOLD, 30));
        f.setPreferredSize(new Dimension(200,100));
        dis.add(f);
        
        add(rew);
        add(dis);
        //add(dis);
        //add(free);
    }
    
}
