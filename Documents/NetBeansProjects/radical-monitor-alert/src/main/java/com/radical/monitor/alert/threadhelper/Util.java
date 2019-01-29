/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radical.monitor.alert.threadhelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author emmanuel.idoko
 */
public class Util {

    public static String getEncodeCredentials(String username, String password) {
        if ((username != null && !username.trim().isEmpty()) && (password != null && !password.trim().isEmpty())) {
            String authString = username + ":" + password;
            return (new Base64().encodeToString(authString.getBytes()));
        } else {
            return "Invalid parameters detected.";
        }
    }

    public static String getEmailTemplate(String tempatePath, String templateName) {
        Path wiki_path = Paths.get(tempatePath, templateName);

        Charset charset = Charset.forName("ISO-8859-1");
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(wiki_path, charset);

            int index = 0;
            System.out.println("Template path \t\t Index");
            for (String line : lines) {
                index++;
                System.out.println(line + "\t\t" + index);
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();
    }

}
