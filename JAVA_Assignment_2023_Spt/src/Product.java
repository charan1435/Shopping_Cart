import java.io.Serializable;

public class Product implements Serializable {
    // attributes are set as private
    private int prID;
    private String prName;
    private double prPrice;

    private int prQuantity;

    //Constructor

    public Product(int prID,String prName,int prQuantity,double prPrice){
        this.prID=prID;
        this.prName=prName;
        this.prQuantity=prQuantity;
        this.prPrice=prPrice;

    }

    public  Product(){

    }


    // Setters are set to access the private attributes
    public void setPrName(String prName) {
        this.prName = prName;
    }
    public void setPrID(int prID){
        this.prID=prID;
    }
    public void setPrPrice(double prPrice){
        this.prPrice=prPrice;
    }
    public void setPrQuantity(int prQuantity){
        this.prQuantity=prQuantity;
    }

    //Getters are set to access the private attributes
    public String getPrName() {
        return prName;
    }
    public int getPrID(){
        return prID;
    }
    public double getPrPrice(){
        return prPrice;
    }
    public int getPrQuantity(){
        return prQuantity;
    }

    //toString Method

    public String toString(){
        return ("Product Name:"+prName + " Product Quantity:"+prQuantity+" Product ID:"+prID );
    }






}
