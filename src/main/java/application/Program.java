package application;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {

        File file = new File("c:\\temp\\in .txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
