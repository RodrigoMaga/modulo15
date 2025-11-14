package application;



import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Exercicio {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        String path = "c:\\temp\\subdir";
        List<Product> productList = new ArrayList<>();

        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\source.csv"))) {
            String line = br.readLine();

            while (line != null) {
                String[] productAttributes = line.split(",");
                productList.add(new Product(productAttributes[0], Double.valueOf(productAttributes[1]), Integer.valueOf(productAttributes[2])));
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean success = new File(path + "\\out").mkdir();
        System.out.println("Criado " + success);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\out\\summary.csv", true))){
            for (Product p : productList) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
