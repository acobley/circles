/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myflix.myflix.lib;

import com.eclipsesource.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author andy
 */
public final class Web {

    public void Web() {

    }

    public static JsonObject GetJson(String url) throws IOException {
        URL videos = null;
        JsonObject RespObj = new JsonObject();
        try {
            videos = new URL(url);
        } catch (Exception et) {
            System.out.println("Videos URL is broken");
            return null;
        }
        HttpURLConnection hc = null;
        try {
            hc = (HttpURLConnection) videos.openConnection();
            String login = ".\\GROW_HL:321Demo";
            final byte[] authBytes = login.getBytes(StandardCharsets.UTF_8);
            final String encoded = Base64.getEncoder().encodeToString(authBytes);
            hc.addRequestProperty("Authorization", "Basic " + encoded);
            hc.setDoInput(true);
            hc.setDoOutput(true);
            hc.setUseCaches(false);
            hc.setRequestMethod("GET");
            //hc.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
            hc.setRequestProperty("Content-Type", "application/hal+json");
            //hc.setRequestProperty("Accept", "application/json");
            hc.setRequestProperty("Accept", "application/json,text/html,application/hal+json,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*");
        } catch (Exception et) {
            System.out.println("Can't prepare http URL con");
            return (null);
        }
        BufferedReader br = null;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(hc.getOutputStream());
            //writer.write("");

        } catch (Exception et) {
            System.out.println("Can't get reader "+et);
        }
        int rc = -1;
        try {
            rc = hc.getResponseCode();
        } catch (Exception et) {
            System.out.println("Can't get reponse code " + et);
        }
        if ((rc == HttpURLConnection.HTTP_OK) || (rc == HttpURLConnection.HTTP_CREATED)) {
            int Length = hc.getContentLength();
            String Content = hc.getContentType();
            String Encoding = hc.getContentEncoding();

            InputStreamReader in = new InputStreamReader((InputStream) hc.getInputStream());
            BufferedReader buff = new BufferedReader(in);

            StringBuffer response = new StringBuffer();
            String line = null;
            try {
                do {
                    line = buff.readLine();
                    if (line != null) {
                        response.append(line);
                    }
                } while (line != null);
            } catch (Exception et) {
                System.out.println("Can't read from input " + et);
            }
            //System.out.println(sBuff);
            try {

                RespObj = JsonObject.readFrom(response.toString());
            } catch (Exception et) {
                System.out.println("Can't create json object from response");
                return null;
            }

        }
        return RespObj;

    }

}
