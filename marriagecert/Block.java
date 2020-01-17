
package marriagecert;

import java.util.Date;
public class Block {
    public String Hash;
    public String prevHash;
    public int index;
    public String husband;
    public String wife;
    public String registrar;
    private Long time;

    public Block(int index, String husband,String wife,String registrar,String prevHash) {   
        this.index = index;
        this.husband = StringUtil.applySha256(husband);
        this.wife = StringUtil.applySha256(wife);
        this.registrar = StringUtil.applySha256(registrar);
        this.prevHash = prevHash;
        this.time = new Date().getTime();
        this.Hash = calHash();
    }

    public String calHash() {
        String calHash = StringUtil.applySha256(prevHash 
        + husband + wife);
        return calHash;
    }
    
    public String toString() {
        return ("{\nBlock Index: "+ index +"\nHash: "+ Hash + "\nPrevious Hash: " + prevHash + "\nHusband: " + husband 
                + "\nWife: " + wife + "\nRegistrar: " + registrar + "\nTime: " + time + "\n");
    }
}
