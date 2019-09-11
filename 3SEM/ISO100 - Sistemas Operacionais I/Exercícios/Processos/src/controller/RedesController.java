package controller;

import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.System.out;

public class RedesController{
	
	public static void redes() throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }
	
	
	static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Nome: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }

        out.printf("\n");
     }
	
	
	public String os(){
		String os = System.getProperty("os.name");
		return os;
	}
	
	public String ip(String os) {
		
		String ip = "";
		
		
		
		
		
		return ip;
	}
	
	public double ping(String os) {
		
		double ping = 0;
		
		
		return ping;
	}
}
