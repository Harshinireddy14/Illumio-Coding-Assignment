package myFirewall;
import java.util.*;
import java.io.*;
public class Accepting_packets extends Firewall{
    static HashSet<Rules> ruleset = new HashSet<Rules>();
    public Accepting_packets(String path)
    {
        super(path);
        processing_file();
    }
    public boolean accept_packet(String direction, String protocol, int port, String IPaddress)
    {
        long ip = Long.parseLong(IPaddress.replaceAll("\\.", ""));
        //System.out.println("The input is "+ip);
        Rules r = new Rules(direction, protocol, port, ip);
        if(ruleset.contains(r))
            return true;
        return false;
    }

   
    public void processing_file(){
        
        String line; 
       String [] words; 
       char charset = '-';
      // path = "sample.csv";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))){
            
       while((line = br.readLine()) != null) {
       // System.out.println("In the try block");
       words =  line.split(",");
       if(words[2].contains("-"))
       {
            String ports[] = words[2].split("-");
            int port1 = Integer.parseInt(ports[0]);
            int port2 = Integer.parseInt(ports[1]);
            int portrange = port2 - port1;
            if(words[3].contains("-"))
            {
                String IPs[] = words[3].split("-");
                long lowerIP = Long.parseLong(IPs[0].replaceAll("\\.", "")); 
                long upperIP = Long.parseLong(IPs[1].replaceAll("\\.", "")); 
                long totalIPS = upperIP - lowerIP;
                for(int i=0; i< totalIPS; i++)
                {
                    for(int j=0; j < portrange; j++)
                    {
                    Rules r = new Rules(words[0],words[1],port1+j,lowerIP+1);
                    ruleset.add(r);
                    }
                }
            }
            else
            {
                long a = Long.parseLong(words[3].replaceAll("\\.", ""));    
                for(int j=0; j < portrange; j++)
                {
                   Rules r = new Rules(words[0],words[1],port1+j,a);
                   ruleset.add(r);
                }
            }
       }
       else{
           if(words[3].contains("-"))
           {
                String IPs[] = words[3].split("-");
                long lowerIP = Long.parseLong(IPs[0].replaceAll("\\.", "")); 
                //System.out.println(lowerIP);
                long upperIP = Long.parseLong(IPs[1].replaceAll("\\.", "")); 
               // System.out.println(upperIP);
                long totalIPS = upperIP - lowerIP;
                for(int i=0; i< totalIPS; i++)
                {
                    lowerIP = lowerIP + 1;
                   // System.out.println("The lower "+lowerIP);
                    int p = Integer.parseInt(words[2]);
                    Rules r = new Rules(words[0],words[1],p,lowerIP);
                    ruleset.add(r);
                }
           }
           else{
               long IP = Long.parseLong(words[3].replaceAll("\\.", "")); 
               int port = Integer.parseInt(words[2]);
               Rules r = new Rules(words[0],words[1],port,IP);
               ruleset.add(r);
           }
       }

    }
    }
    catch (FileNotFoundException e) {
        System.out.println("Cannot find file "+ path );
    }
    catch(Exception e) {
        System.out.println("Exeption occured " + e.getMessage());
    }
}
}