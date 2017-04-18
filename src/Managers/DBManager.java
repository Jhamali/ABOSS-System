/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Objects.Collection;
import Objects.Main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class DBManager {

    JSONObject j;
    File fl;

    public DBManager(JSONObject ob, File fil) {
        j = ob;
        fl = fil;
    }

    public void addToJSON(String key, String update) {
        j.put(key, update);
        Main.updateJSON(j);
    }

    public void write(String key, String update) throws IOException {
        addToJSON(key, update);
        FileWriter jFW = new FileWriter(fl, false);
        String t = j.toString();
        System.out.println(t);
        jFW.write(j.toString());
        jFW.close();
        
    }
    
    public JSONObject getJSON()
    {
        return j;
    }
    
    public void updatePoints(String key, Collection col) throws IOException{
        
        JSONObject j1 = new JSONObject(j.getString(key));
        int point = j1.getInt("points");
        
        int added = col.getPoints();
        int updated = point + added;
        j1.put("points", updated);
        String j2 = j1.toString();
        write(key, j2);
        
        
    }
    
    public void redeemed(int points, String key) throws IOException{
        JSONObject j1 = new JSONObject(j.getString(key));
        j1.put("points", points);
        String j2 = j1.toString();
        write(key, j2);
        
    }

   
}
