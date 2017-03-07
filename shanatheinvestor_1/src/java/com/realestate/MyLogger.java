/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shana
 */
public class MyLogger {

    public static void log(String text) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File("C:/Users/Shana/Documents/logger.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                lines.add(input.nextLine());
            }
            input.close();
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        try {
            File file = new File("C:/Users/Shana/Documents/logger.txt");
            FileWriter writer = new FileWriter(file);
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
