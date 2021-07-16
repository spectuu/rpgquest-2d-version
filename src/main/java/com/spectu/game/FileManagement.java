package com.spectu.game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement{

    public static void createFile(String fileName) {

        File file = new File(fileName);

        try {
            PrintWriter exit = new PrintWriter(file);
            exit.close();
            System.out.println("The file has been created.");
        } catch (FileNotFoundException ex) {

            ex.printStackTrace(System.out);
        }
    }

    public static void addInformation(String fileName, String text) {

        File file = new File(fileName);

        try {
            PrintWriter exit = new PrintWriter(new FileWriter(file, true));
            exit.println(text);
            exit.close();
            System.out.println("The information was added successfully");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static List<String> readFile(String fileName) {

        File file = new File(fileName);
        List<String> list = new ArrayList();

        try {
            BufferedReader enter = new BufferedReader(new FileReader(file));
            String readLine = enter.readLine();
            while (readLine != null) {
                list.add(readLine);
                readLine = enter.readLine();
            }
            enter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }

}
