package experiment05_rmi;

//1. PalindromeI.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PalindromeI extends Remote {
 boolean isPalindrome(String input, int choice) throws RemoteException;
}
