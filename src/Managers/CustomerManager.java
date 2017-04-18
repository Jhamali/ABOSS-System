/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Objects.Customer;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class CustomerManager {

    static ArrayList<Customer> allCus = new ArrayList<Customer>();

    public static ArrayList all(JSONObject j) {
        for (Object key : j.keySet()) {

            String keyStr = (String) key;
            System.out.println(keyStr);
            String s = j.getString(keyStr);
            JSONObject j1 = new JSONObject(s);
            String name = j1.getString("name");
            System.out.println(name);
            String id = j1.getString("iID");
            System.out.println(id);
            String ud = j1.getString("uID");
            String a = j1.getString("address");
            int points = j1.getInt("points");
            allCus.add(new Customer(id, ud, name, a, points));
            System.out.println("key: " + keyStr);

        }
        return allCus;
    }

    public static Customer create(JSONObject j, String key) {
        String s = j.getString(key);
        JSONObject j1 = new JSONObject(s);
        String id = j1.getString("iID");
        String ud = j1.getString("uID");
        String name = j1.getString("name");
        String a = j1.getString("address");
        int point = j1.getInt("points");
        System.out.println(point);
        return (new Customer(id, ud, name, a, point));
    }

}
