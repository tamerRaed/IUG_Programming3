/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases_Lambdas_Streams.Q3;

/**
 *
 * @author hp
 */
public class Invoice {
    private int PartNumber;
    private String PartDescription;
    private int Quantity;
    private double Price;

    @Override
    public String toString() {
        return "Invoice{" + "PartNumber=" + PartNumber + ", PartDescription=" + PartDescription + ", Quantity=" + Quantity + ", Price=" + Price + '}';
    }

    public Invoice(int PartNumber, String PartDescription, int Quantity, double Price) {
        this.PartNumber = PartNumber;
        this.PartDescription = PartDescription;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public int getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(int PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getPartDescription() {
        return PartDescription;
    }

    public void setPartDescription(String PartDescription) {
        this.PartDescription = PartDescription;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
