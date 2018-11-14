package myFirewall;
/* This is an abstract class  */
import java.util.*;
import java.io.*;
public abstract class Firewall
{
    public String path;
    
    public Firewall(String path)
    {
        this.path = path;
        return;
    }
    // This Fucntion is to accept File and process it and store store each record
    abstract public void processing_file();
    /*This Function is to accept the incoming packets and return true if they all follow
     the  Rules */ 
    abstract public boolean accept_packet(String direction, String protocol, int port, String IPaddress);
    //This Fumction can be implemented to block the packets based on the file
    //abstract boolean reject_packet(String direction, String protocol, int port, String IPaddress);


}