package org.example;

import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileWriter writer = null;
        FileReader reader = null;
        try {
            writer = new FileWriter("/home/chandini/maven/IdeaProjects/mavenPractice/src/main/resources/emps.csv", true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("\n1,Krish,27,India");
            buffer.close();
            reader = new FileReader("/home/chandini/maven/IdeaProjects/mavenPractice/src/main/resources/emps.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            writer.close();
            reader.close();
        }
    }
}
