/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases_Lambdas_Streams.Q3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class mainApp {

    public static void main(String[] args) {

        Invoice[] array = {
            new Invoice(83, "Electric sander", 7, 57.98),
            new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50),
            new Invoice(77, "Hammer", 76, 11.99),
            new Invoice(39, "Lawm nower", 3, 79.50),
            new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21, 11.00),
            new Invoice(3, "Wrench", 34, 7.50)
        };

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            Statement sta = con.createStatement();

            PreparedStatement ps = con.prepareStatement("INSERT into invoice(Part_Number,Part_Description,Quantity,Price) VALUES(?,?,?,?)");
            for (Invoice invoice : array) {
                ps.setInt(1, invoice.getPartNumber());
                ps.setString(2, invoice.getPartDescription());
                ps.setInt(3, invoice.getQuantity());
                ps.setDouble(4, invoice.getPrice());
                ps.addBatch();
            }

            ResultSet rs = sta.executeQuery("SELECT * from invoice");
            ArrayList<Invoice> invoices = new ArrayList<>();
            while (rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getInt("Part_Number"),
                        rs.getString("Part_Description"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price")
                );
                invoices.add(invoice);
            }

            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getPartDescription()))
                    .forEach(s -> System.out.println(s));

            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getPrice()))
                    .forEach(s -> System.out.println(s));

            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity()))
                    .map(i -> i.getPartDescription() + " " + i.getQuantity())
                    .forEach(s -> System.out.println(s));

            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity() * i.getPrice()))
                    .map(i -> i.getPartDescription() + " " + (i.getPrice() * i.getQuantity()))
                    .forEach(s -> System.out.println(s));

            invoices.stream()
                    .sorted(Comparator.comparing(i -> i.getQuantity() * i.getPrice()))
                    .filter(i -> (i.getQuantity() * i.getPrice()) >= 200 && (i.getQuantity() * i.getPrice()) <= 500)
                    .map(i -> i.getPartDescription() + " " + (i.getPrice() * i.getQuantity()))
                    .forEach(s -> System.out.println(s));

        } catch (ClassNotFoundException ex) {
            System.err.println("Class Not Found!!!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.err.println("SQL Error!!!");
            ex.printStackTrace();

        }
    }
}
