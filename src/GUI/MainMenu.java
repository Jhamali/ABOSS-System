/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Adapters.ScannerAdapter;
import Objects.Main;
import Managers.DBManager;
import static Objects.Main.f;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dubze
 */
public class MainMenu extends JPanel {

    JButton newC = new JButton("ADD NEW CUSTOMER");
    JButton bar = new JButton("SCAN BARCODE");
    JButton view = new JButton("VIEW ALL CUSTOMERS");

    DBManager db;

    Image img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\dubze\\Desktop\\ABOSS Loyalty Point System\\Logo.jpg");

    public MainMenu(DBManager db) {
        //setBackground(new Color(51, 255, 51));
        //img = Toolkit.getDefaultToolkit().createImage("Logo.jpg");
        //Image img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\dubze\\Desktop\\ABOSS Loyalty Point System\\Logo.jpg");
        //JLabel lb = new JLabel(new ImageIcon(img));

        setOpaque(false);
        this.db = db;
        setLayout(new GridLayout(10, 1));
        newC.setPreferredSize(new Dimension(200, 50));
        bar.setPreferredSize(new Dimension(200, 50));
        view.setPreferredSize(new Dimension(200, 50));
        newC.addActionListener(new newButton());
        bar.addActionListener(new cusOption());
        view.addActionListener(new allCus());
        newC.setBackground(Color.BLACK);
        newC.setForeground(Color.WHITE);
        newC.setFont(new Font("Arial", Font.BOLD, 30));
        bar.setBackground(Color.BLACK);
        bar.setForeground(Color.WHITE);
        bar.setFont(new Font("Arial", Font.BOLD, 30));
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
       // view.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel f = new JPanel();

        f.setLayout(new GridLayout(1, 2));
        f.setPreferredSize(new Dimension(1000, 50));

        JPanel v = new JPanel();
        v.setLayout(new GridLayout(1, 10));

        f.setBackground(new Color(255, 51, 51));

        v.setBackground(new Color(255, 51, 51));

        f.setOpaque(false);

        v.setOpaque(false);

        f.setPreferredSize(new Dimension(720, 404));

        f.add(newC);
        f.add(bar);

        add(f);

        JPanel s = new JPanel();
        JPanel s1 = new JPanel();
        JPanel s2 = new JPanel();
        JPanel s3 = new JPanel();
        JPanel s4 = new JPanel();
        JPanel s5 = new JPanel();
        JPanel s6 = new JPanel();
        JPanel s7 = new JPanel();
        s.setOpaque(false);
        s1.setOpaque(false);
        s2.setOpaque(false);
        s3.setOpaque(false);
        s4.setOpaque(false);
        s5.setOpaque(false);
        s6.setOpaque(false);
        s7.setOpaque(false);
        add(s);
        add(s1);
        add(s2);
        add(s3);
        add(s4);
        add(s5);
        add(s6);
        add(s7);
        JPanel v1 = new JPanel();
        JPanel v2 = new JPanel();
        JPanel v3 = new JPanel();
        JPanel v4 = new JPanel();
        JPanel v5 = new JPanel();
        JPanel v6 = new JPanel();
        JPanel v7 = new JPanel();
        JPanel v8 = new JPanel();
        JPanel v9 = new JPanel();
        v1.setOpaque(false);
        v2.setOpaque(false);
        v3.setOpaque(false);
        v4.setOpaque(false);
        v5.setOpaque(false);
        v6.setOpaque(false);
        v7.setOpaque(false);
        v8.setOpaque(false);
        v9.setOpaque(false);
        v.add(v1);
        v.add(v2);
        v.add(v3);
        v.add(v4);
        v.add(v5);
        v.add(v6);
        v.add(v7);
        v.add(v8);
        v.add(v9);
        v.add(view);
        JPanel space = new JPanel();
        space.setLayout(new GridLayout(5,1));
        space.setOpaque(false);
        JPanel z1 = new JPanel();
        JPanel z2 = new JPanel();
        JPanel z3 = new JPanel();
        JPanel z4 = new JPanel();
        z1.setOpaque(false);
        z2.setOpaque(false);
        z3.setOpaque(false);
        z4.setOpaque(false);
        space.add(z1);
        space.add(z2);
        space.add(z3);
        space.add(z4);
        space.add(v);
        add(space);
    }

    class newButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            //f.getContentPane().removeAll();
            //f.getContentPane().add(new AddCustomer());
            AddCustomer ac = new AddCustomer(db);
            int h = JOptionPane.showConfirmDialog(null, ac, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (h == JOptionPane.OK_OPTION) {
                try {
                    ac.addC();
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //Main.refresh(new MainMenu());
            }

            // f.validate();
            // f.setVisible(true);
        }
    }

    class cusOption implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            try {
                //f.getContentPane().removeAll();

                //f.getContentPane().add(new CustomerMenu());
                //f.validate();
                //f.setVisible(true);
                String code = ScannerAdapter.getCode();
                Main.refresh(new CustomerMenu(code, db));
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class allCus implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Main.refresh(new CustomerView(db));
        }
    }

}
