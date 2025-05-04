package experiment05_rmi;

// 2. PalindromeC.java

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PalindromeC extends UnicastRemoteObject implements PalindromeI {
    public PalindromeC() throws RemoteException {
        super();
    }

    public boolean isPalindrome(String input, int choice) throws RemoteException {
        switch (choice) {
            case 1: 
                return isStringPalindrome(input);
            case 2: 
                return isStringPalindrome(Integer.toString(Integer.parseInt(input)));
            default:
                throw new IllegalArgumentException("Invalid choice!");
        }
    }

    private boolean isStringPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
