/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.r2dvd.sosreader;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.JsonArray;
import com.myflix.myflix.lib.Web;

/**
 *
 * @author andyc
 */
public class ReaderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String videos = "http://grow-beta-api.hydronet.com/api/service/sos?service=SOS&request=getcapabilities&Version=2.0.0&ResponseFormat=application/JSON";

        JsonObject obj = new JsonObject();
        try {
            obj = Web.GetJson(videos);

            System.out.println(obj.names());

            JsonValue Value = obj.get("Contents");
            JsonValue offering=obj.get("offering");
                
            
            System.out.println(offering);
           

        } catch (Exception et) {
            System.out.println("Broken" + et);
            System.exit(-1);
        }

    }

}
