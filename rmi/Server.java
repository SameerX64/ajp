package experiment05_rmi;

//3. Server.java


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
 public static void main(String[] args) {
     try {
         PalindromeC obj = new PalindromeC();
         Registry registry = LocateRegistry.createRegistry(5000);
         registry.bind("PALINDROME", obj);
         System.out.println("Server is running...");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
