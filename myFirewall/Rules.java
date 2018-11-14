package myFirewall;
public class Rules
{
    private String direction;
    private String protocol;
    private int port;
    private long IPaddress;

    public Rules(String direction, String protocol, int port, long IPaddress)
    {
        this.direction = direction;
        this.protocol = protocol;
        this.port = port;
        this.IPaddress = IPaddress;
    }
   
     public boolean equals(Object o) {
        
        if (this == o) return true;
         if (!(o instanceof Rules)) return false;
         Rules r = (Rules) o;
         return  direction.equals(r.direction) && protocol.equals(r.protocol) && port == r.port && IPaddress == r.IPaddress;
         //return true;

     }
     public int hashCode() {
         //long this.IPaddress;
         long code = this.IPaddress + this.port +  this.direction.hashCode() + this.protocol.hashCode();
         return (int)code;
     }

}