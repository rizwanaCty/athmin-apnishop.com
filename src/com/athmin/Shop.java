package com.athmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Shop {
    public int option,count=0;
    public String product,yesOrNo;
    public HashMap<String, Integer> shopingCart = new HashMap<String, Integer>();
    public static void main(String[] args){
        Shop shop = new Shop();
        shop.showWelcomeMessage();
        shop.showOptions();

    }

//    To print welcome message
    void showWelcomeMessage(){
        String message="WELCOME TO APNISHOP.COM...";
        for(int i=0; i<message.length();i++){
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(250);
            }
            catch (InterruptedException e){
            }
        }
    }

//    to get option to continue to shope
    private void showOptions() {
        System.out.println("\nTo continue shopping press any digit 1 to 9\nTo discard_shopping/payment press 0.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            if(validateOption(input)){
                if(option>=1 && option<=9){
                    showProducts();
                }
                else if(option==0){
                    if(isCartEmpty()){
                        System.out.println("Product selected by you: 0\n");
                        exitShope();
                    }else
                        checkCart();
                }
                else{
                    System.out.println("Invalid input");
//                    System.out.println("Please enter a number between 0-9");
                    showOptions();
                }
            }else {
                System.out.println("Invalid input");
                showOptions();
                return;
            }

        }
        catch (IOException e) {
            System.out.println("Invalid Input");
        }

    }

//    to show all product list
    private void showProducts() {
        System.out.println("Please select your items by pressing corresponding letter....\n" +
                "For Mobile press: A\n" +
                "For Tab press: B\n" +
                "For Laptop press: C\n" +
                "For Headphone press: D\n" +
                "For Sound_System press: E\n" +
                "For Keyboard press: F\n" +
                "For Mouse press: G\n" +
                "For Pendrive press: H\n" +
                "For Led_Screen press: I\n" +
                "For Ups press: J\n" +
                "For Payment/Exit 0.");

        chooseProduct();
    }

//    to choose product
    private void chooseProduct() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            product = br.readLine();
        }catch (IOException e){
        }

        switch (product.toUpperCase()){
            case "A":
                System.out.println("Product details:\n" +
                        "\tprice=10000;\n" +
                        "\tram=\"4gb\";\n" +
                        "\tinternal_memory=\"8gb\";\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"Samsung\";\n" +
                        "\taccessories=\"charger,headphone,8gb_memory_card\";");
                validateAddProductToCart("Mobile","10000");
                break;
            case "B":
                System.out.println("Product details:\n" +
                        "\tprice=15000;\n" +
                        "\tram=\"4gb\";\n" +
                        "\tinternal_memory=\"32gb\";\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"Reliance\";\n" +
                        "\taccessories=\"charger,headphone,16gb_memory_card\";");
                validateAddProductToCart("Tab","15000");
                break;
            case "C":
                System.out.println("Product details:\n" +
                        "\tprice=30000;\n" +
                        "\tram=\"8gb\";\n" +
                        "\thard_disk=1 tera_byte\";\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"Lenovo\";\n" +
                        "\taccessories=\"charger,headphone,32gb_memory_card,bag\";");
                validateAddProductToCart("Laptop","30000");
                break;
            case "D":
                System.out.println("Product details:\n" +
                        "\tprice=400;\n" +
                        "\twaranty=\"6 month\";\n" +
                        "\tcompany=\"Samsung\";");
                validateAddProductToCart("Headphone","400");
                break;
            case "E":
                System.out.println("Product details:\n" +
                        "\tprice=3000;\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"creative\";\n" +
                        "\tspeakers=\"4.1\";");
                validateAddProductToCart("Sound_System","3000");
                break;
            case "F":
                System.out.println("Product details:\n" +
                        "\n" +
                        "\tprice=500;\n" +
                        "\twaranty=\"1 years\";\n" +
                        "\tcompany=\"Dell\";\n");
                validateAddProductToCart("Keyboard","500");
                break;
            case "G":
                System.out.println("Product details:\n" +
                        "\tprice=200;\n" +
                        "\twaranty=\"1 years\";\n" +
                        "\tcompany=\"Iball\";");
                validateAddProductToCart("Mouse","200");
                break;
            case "H":
                System.out.println("Product details:\n" +
                        "\n" +
                        "\tprice=300;\n" +
                        "\twaranty=\"no waranty\";\n" +
                        "\tsize=\"16gb\";");
                validateAddProductToCart("Pendrive","300");
                break;
            case "I":
                System.out.println("Product details:\n" +
                        "\tprice=15000;\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"LG\";\n" +
                        "\taccessories=\"headphone,16gb_memory_card\";");
                validateAddProductToCart("LED","15000");
                break;
            case "J":
                System.out.println("Product details:\n" +
                        "\tprice=10000;\n" +
                        "\twaranty=\"2 years\";\n" +
                        "\tcompany=\"Luminous\";");
                validateAddProductToCart("UPS","10000");
                break;
            case "0":
                if(isCartEmpty()){
                    showOptions();
                }else{
                    checkCart();
                }
                break;
            default:
                System.out.println("Invalid Entry");
                showProducts();
        }

    }

//    check cart is empty or not
    private boolean isCartEmpty() {
        if(shopingCart.size()<=0) {
            return true;
        }else
            return false;
    }

//    check cart items....if required items can be removed
    private void checkCart() {
        int index=1;
        System.out.println("Total number of Products in your cart is:"+shopingCart.size()+"\nProduct selected by you:");
        for (String item : shopingCart.keySet()) {
            System.out.println(index+". "+item);
            index++;
        }
        System.out.println("\nDo you want to remove any item from cart:.\n" +
                "If yes then press Y else press N");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        try {
            String remove = b.readLine();
            switch (remove.toUpperCase()){
                case "Y":
                    removeFromCart();
                    break;
                case "N":
                    modeOfpayment();
                    break;
                default:
                    System.out.println("Invalid entry");
                    checkCart();
            }
        }catch (IOException e){
        }

    }

//    to select mode of payment
    private void modeOfpayment() {
        System.out.println("Please select your mode of payment:\n" +
                "Press 1 for: Credit Card.\n" +
                "Press 2 for: Debit Card.");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String mode;
        try {
            mode= b.readLine();
            if(validateOption(mode)){
                if(option==1||option==2){
                    cardPayment(option);
                }else{
                    System.out.println("Please enter a valid input");
                    modeOfpayment();
                }

            }else {
                System.out.println("Please enter a valid input");
                modeOfpayment();
            }
        }catch (IOException e){
        }
    }

    //for debit and credit payment
    private void cardPayment(int card) {
        System.out.println("Please enter your pin number:");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String pin;
        int sum=0;

        for (int price : shopingCart.values()) {
            sum += price;
        }

        try {
            pin = b.readLine();
            System.out.println("Processing...");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
//to check dis mode debit card
            if(card==2) {
                if (pin.equals("101103")) {
                    System.out.println("you choose debit Card, so you have got 5% discount.\n" +
                            "your bill: " + sum * 0.95);
                    exitShope();
                }
                else {
                    count++;
                    checkAttempt(card);
                }
            }
            else{
                if(pin.equals("101102")) {
                    System.out.println("you choose Credit Card, so you have charged 5% cess\n" +
                            "your bill: " + (sum * 0.05+sum));
                    exitShope();
                } else {
                    count++;
                    checkAttempt(card);
                }
            }
        }
        catch(IOException e){
        }
    }

    //to exit from program
    private void exitShope() {
        System.out.println("Thanks for choosing apni_shop.com...");
        System.exit(0);
    }

//    to check how many attempts for pin entry
    private void checkAttempt(int card) {
        if(count<3){
            System.out.println("Wrong pin\nYou have " + (3 - count) + " attempts left");
            cardPayment(card);
        }
        else{
            exitShope();
        }
    }

//to remove item from cart
    private void removeFromCart() {
        System.out.println("Enter the name of product that you want to remove:");

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String item;
        try {
            item= b.readLine();
            if (shopingCart.containsKey(item)){
                shopingCart.remove(item);
                checkCart();

            }else {
                System.out.println("Please enter a valid product name");
                removeFromCart();
            }
        }catch (IOException e){

        }
    }

    //to check input is a number or not
    private boolean validateOption(String input) {
        try {
            option = Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    //to add item to cart / not
    private void validateAddProductToCart(String item, String price){
        System.out.println("Do you want to add this item in cart.\n" +
                "If yes then press Y else press N");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        try {
            yesOrNo = b.readLine();
        }catch (IOException e){

        }
        switch (yesOrNo.toUpperCase()){
            case "Y":
                shopingCart.put(item,Integer.parseInt(price));
                showProducts();
                break;
            case "N":
                showProducts();
                break;
            default:
                System.out.println("Invalid entry");
                validateAddProductToCart(item,price);
        }
    }


}
