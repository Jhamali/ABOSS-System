package GUI;

import Managers.QRManager;
import Managers.eMail;
import Managers.DBManager;
import Managers.IDGenerator;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dubze
 */
public class AddCustomer extends JPanel {

    JTextField iID = new JTextField(20);

    JTextField name = new JTextField(30);

    JTextField add = new JTextField(30);

    JTextField email = new JTextField(30);

    DBManager dbM;

    public AddCustomer(DBManager dbM) {

        this.dbM = dbM;

        setLayout(new GridLayout(4, 0));

        JPanel pID = new JPanel();
        // pID.setPreferredSize(new Dimension(800,100));
        JLabel id = (new JLabel("Enter Initial ID "));
        id.setPreferredSize(new Dimension(200, 50));
        pID.add(id);
        iID.setPreferredSize(new Dimension(200, 50));
        pID.add(iID);
        add(pID);

        JPanel pN = new JPanel();
        JLabel n = new JLabel("Enter name");
        n.setPreferredSize(new Dimension(200, 50));
        pN.add(n);
        name.setPreferredSize(new Dimension(200, 50));
        pN.add(name);
        add(pN);

        JPanel pA = new JPanel();
        JLabel a = new JLabel("Enter address");
        a.setPreferredSize(new Dimension(200, 50));
        pA.add(a);
        add.setPreferredSize(new Dimension(200, 50));
        pA.add(add);
        add(pA);

        JPanel e = new JPanel();
        JLabel em = new JLabel("Enter e-mail");
        em.setPreferredSize(new Dimension(200, 50));
        e.add(em);
        email.setPreferredSize(new Dimension(200, 50));
        e.add(email);
        add(e);

    }

    void addC() throws IOException {
        String i = iID.getText();
        String n = name.getText();
        String a = add.getText();
        String u = "";
        String mail = email.getText();
        Boolean free = false;
        while (!free) {
            IDGenerator idg = new IDGenerator();
            u = (String) idg.nextSessionId();
            JSONObject jb = dbM.getJSON();
            if (jb.isNull(u)) {
                free = true;
            }

        }

        String cust = "{iID:" + i + ",uID:" + u + ",name:" + n + ",address:" + a + ",points:" + 0 + "}";
        dbM.write(u, cust);
        QRManager.newCode(u);
        eMail.send(mail);

        System.out.println(cust);
    }

}
