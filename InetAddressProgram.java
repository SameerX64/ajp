package practicals;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println("Address of local host: " + ip1 + "\n");

            InetAddress ip2 = InetAddress.getByName("www.youtube.com");
            System.out.println("Address of string host: " + ip2 + "\n");

            byte[] ipaddress = {10, 10, 13, 38};
            InetAddress ip3 = InetAddress.getByAddress(ipaddress);
            System.out.println("Host name for IP address: " + ip3 + "\n");

            InetAddress[] ip4 = InetAddress.getAllByName("www.pict.edu");
            for (InetAddress inetAddress : ip4) {
                System.out.println("Address of URL: " + inetAddress + "\n");
            }

            InetAddress ip5 = InetAddress.getByAddress("pict.edu", ipaddress);
            System.out.println("InetAddress of host with IP address and hostname: " + ip5 + "\n");

            // Instance Methods
            System.out.println("Host name of InetAddress: " + ip2.getHostName());
            System.out.println("Address of host held by InetAddress object: " + ip2.getHostAddress());
            System.out.println("Address equals local host: " + ip2.equals(ip1));
            System.out.println("toString conversion: " + ip2);
            System.out.println("Is it a multicast address? " + ip2.isMulticastAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve host. " + e.getMessage());
        }
    }
}
