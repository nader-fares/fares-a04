/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
package baseline;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution44 {
    public static void main(String[] args) {
        Solution44 app = new Solution44();
        Scanner input = new Scanner(System.in);

        //declare class of a list of products
        ItemShop shop = app.productDeserialization();   //store json file data into shop

        boolean isFound;             //loop escape condition

        do {
            //prompt for product name and store string
            System.out.print("What is the product name? ");
            String productName = input.nextLine();

            isFound = app.checkForItem(productName, shop);    //prints item details if found

            if (!isFound)
                System.out.println("Sorry, that product was not found in our inventory.");

        } while (!isFound);            //else keep looping until found

    }


    public ItemShop productDeserialization() {
        ItemShop shop = new ItemShop();

        //read json file
        try {
            try (Reader reader = Files.newBufferedReader(Paths.get("./data/exercise44_input.json"))) {
                shop = new Gson().fromJson(reader, ItemShop.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shop;
    }

    public boolean checkForItem(String productName, ItemShop shop) {
        //search through list of product object names for input
        for (int i = 0; i < shop.products.size(); i++) {
            //if found print out name, price and quantity
            if (shop.products.get(i).getName().equalsIgnoreCase(productName)) {
                System.out.println("Name: " + shop.products.get(i).getName());
                System.out.println("Price: " + shop.products.get(i).getPrice());
                System.out.println("Quantity: " + shop.products.get(i).getQuantity());
                return true;     //escape loop
            }
        }
        return false;   //item does not exist
    }

}
