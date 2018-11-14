import myFirewall.*;
import java.util.*;
import java.io.*;
public class packets{
    public static void main(String args[])
    {
       String path = "sample.csv";
       
       boolean result;
       //sample inputs from the document
       /*
       System.out.println("Following are the test cases from the document");
       result = f.accept_packet("inbound", "tcp", 80, "192.168.1.2");// true
       System.out.println(result);
       result = f.accept_packet("inbound", "udp", 53, "192.168.2.1"); // true
       System.out.println(result);
       
       result = f.accept_packet("outbound", "tcp", 10234, "192.168.10.11"); // true
       System.out.println(result);
       result = f.accept_packet("inbound", "tcp", 81, "192.168.1.2"); //false
       System.out.println(result);
       result = f.accept_packet("inbound", "udp", 24, "52.12.48.92"); // false
       System.out.println(result);
    */
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the file path, if you sould like to use a sample file please enter sample.csv");
       path=sc.next();
       Firewall fa = new Accepting_packets(path);
       fa.processing_file();
      // Firewall fa = (Accepting_packets)f;
       System.out.println("Please enter input separated by spaces");
       System.out.println("Sample input would be - inbound tcp 80 192.168.1.2");
    
       String direction = sc.next();
       String protocol = sc.next();
       int port = sc.nextInt();
       String IPaddress = sc.next();
    
       sc.close();
       result = fa.accept_packet(direction, protocol, port, IPaddress); // true
       if(result == true)
            System.out.println("packet Accepted!!!");
        else
            System.out.println("packet not accepted!!!");
    
    }}