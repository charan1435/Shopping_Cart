import java.io.*;
import java.util.List;

public class ProductManager {
    private static String FILENAME = "products";

    public List<Product> saveProducts(List<Product> cartList) {
        List<Product> existingProducts = loadProducts(); // Read existing data from the file
        if (existingProducts != null) {
            cartList.addAll(existingProducts); // Append new data to the existing data
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cartList);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Occurred");
        }


        return cartList;
    }
    public  int getProductID(){
        List<Product> product = loadProducts();
        if (product!=null && !product.isEmpty()){
            // Get the last product in the list
            Product lastProduct = product.get(product.size()-1);
            return lastProduct.getPrID();
        }
        return -1; //Return -1 to indicate no product found or file is empty
    }


    public List<Product> loadProducts() {
        List<Product> loadedProducts = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            loadedProducts = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();  // Close the ObjectInputStream
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Occurred");
        }
        return loadedProducts;
    }

    public Product findById(int productID) {
        List<Product> products = loadProducts();
        if (products != null) {
            for (Product product : products) {
                if (product.getPrID() == productID) {
                    return product;
                }
            }
        }
     return null;
    }

}



