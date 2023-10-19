import java.util.*;

public class ShoppingCart {

    //Program has  error in file writing where it is always writing to file not appending

    public static List<Product> cartItems = new ArrayList<>();
    static String InputWord;
    private static int count = 0;
    static int applePrice= 100;
    static  int orangePrice=200;
    static  int papayaPrice=300;

    static int coconutPrice=110;
    static double totalAmount;
    //Stock of Products available
    static int appleStock = 20;
    static int orangeStock = 20;
    static int coconutStock = 20;
    static int papayaStock = 20;










    public static void main(String[] args) {
        try {
            ProductManager productManager = new ProductManager();
            List<Product> loadedProducts = productManager.loadProducts();
            int lastProductID = productManager.getProductID();
            if (lastProductID==-1){

                System.out.println("No Products exist prior");
            }else {
                count=lastProductID;

            }



            if (loadedProducts != null) {
                System.out.println(productManager.loadProducts());

            } else {
                System.out.println("Failed to load products.");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error While Loading!..");
        }






        boolean exit = false;

        do {
            System.out.println("| Enter * ADD * to add products to cart ");
            System.out.println("|Enter * DELETE * to delete products from cart ");
            System.out.println("|Enter * EXIT * to exit from the program ");
            System.out.println("|Enter * TOTAL * to calculate the total from cart ");
            System.out.println("|Enter * DISPLAY * to view all products from cart ");
            System.out.println("|Enter * ID * to view specific product from cart using  ID number ");
            System.out.println("|Enter * UPDATE * to save the cart elements to File for later backup ");

            Scanner readInput= new Scanner(System.in);
            InputWord=readInput.nextLine().toUpperCase();
            switch (InputWord){
                case "ADD" -> addFunction();
                case "DELETE" -> deleteFunction();
                case "EXIT" -> {
                    exit = true;
                }
                case "TOTAL" -> totalFunction();
                case "DISPLAY" -> displayFunction();
                case "ID" -> idFunction();
                case "UPDATE" -> fileFunction();
                default -> System.out.println("Invalid");

            }

        }while (!exit);



    }

    public static void addFunction(){
        count++;
        System.out.println("ADD");
        try {




            System.out.println("What is the product you want to ADD");
            System.out.println("");
            System.out.println("You could add Only APPLE | ORANGE | COCONUT | PAPAYA");
            System.out.println("*** PROGRAM WILL NOT IDENTIFY OTHER INPUTS ***");
            Scanner scn = new Scanner(System.in);
            String productName = scn.nextLine();
            if (productName.equalsIgnoreCase("apple") || productName.equalsIgnoreCase("orange") || productName.equalsIgnoreCase("coconut") || productName.equalsIgnoreCase("papaya")){
                System.out.println("Enter Quantity in Integer");
                int  productQuantity =scn.nextInt();

                if (productName.equalsIgnoreCase("apple") && !(appleStock <=0)){
                    double applePriceFinal= productQuantity*applePrice;
                    Product product = new Product(count,productName,productQuantity,applePriceFinal);
                    cartItems.add(product);
                    System.out.println("Product:"+productName + " has been successfully added");
                    appleStock=(appleStock-productQuantity);


                } else if (productName.equalsIgnoreCase("orange") && !(orangeStock <=0)){
                    double orangePriceFinal= productQuantity*orangePrice;
                    Product product = new Product(count,productName,productQuantity,orangePriceFinal);
                    cartItems.add(product);
                    System.out.println("Product:"+productName + " has been successfully added");

                } else if (productName.equalsIgnoreCase("coconut") && !(coconutStock <=0)) {
                    double coconutPriceFinal= productQuantity*coconutPrice;
                    Product product = new Product(count,productName,productQuantity,coconutPriceFinal);
                    cartItems.add(product);
                    System.out.println("Product:"+productName + " has been successfully added");

                } else if (productName.equalsIgnoreCase("papaya") && !(papayaStock <=0)) {
                    double papayaPriceFinal= productQuantity*papayaPrice;
                    Product product = new Product(count,productName,productQuantity,papayaPriceFinal);
                    cartItems.add(product);
                    System.out.println("Product:"+productName + " has been successfully added");

                }
                else {
                    System.out.println("NO STOCK AVAILABLE OF THIS PRODUCT");
                }

                // prID=random.nextInt(1000);



            }else {
                System.out.println("*** PRODUCT Not Found!...***");
            }



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Invalid or Error Occurred");
        }

    }

    public static void deleteFunction() {
        System.out.println("DELETE");
        System.out.println("Enter the product name to delete from the cart:");
        Scanner scn = new Scanner(System.in);
        String deleteElement = scn.nextLine();

        // Iterate through cartItems to find and remove the product by name
        Iterator<Product> iterator = cartItems.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getPrName().equalsIgnoreCase(deleteElement)) {
                iterator.remove(); // Remove the product from the list
                found = true;
                System.out.println(deleteElement + " removed from the cart.");
                break; // Exit the loop once the product is found and removed
            }
        }

        if (!found) {
            System.out.println(deleteElement + " not found in the cart.");
        }
    }

    public static void totalFunction(){
        System.out.println("TOTAL");
        for (Product product:cartItems){
            double totalOfProducts=product.getPrPrice();
            totalAmount += totalOfProducts;
        }
        System.out.println("Total For Your Cart is :" + totalAmount);
    }

    public static void displayFunction(){
        System.out.println("DISPLAY");
        if (cartItems.isEmpty()){
            System.out.println("Cart is EMPTY");
        }else {
            for (Product product : cartItems){
                System.out.println("Product Name:"+product.getPrName()+ " Has Product ID: "+ product.getPrID()+ "Has a price of: "+ product.getPrPrice());
            }

        }

    }

    public static void idFunction(){
        ProductManager productManager = new ProductManager();
        System.out.println("Enter the ID you want to search the file");
        Scanner scn = new Scanner(System.in);
        int inSearch= scn.nextInt();
        Product foundByFile= productManager.findById(inSearch);
        if (foundByFile!= null){
            System.out.println("Product Found :" + foundByFile.getPrName()) ;
        } else {
            System.out.println("File not found");
        }

    }

    public static void fileFunction(){
        //Passing the cartItems as a parameter to the product manager class
        ProductManager productManager = new ProductManager();


        productManager.saveProducts(cartItems);

        System.out.println("File has been updated *** File Name: products ***");
    }




}
