
package marriagecert;

import java.util.Scanner;
import java.util.ArrayList;

public class Marriagecert {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static ArrayList<Block> newchain = new ArrayList<Block>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int num = 0 ;
        int x = 0;
        String hand;
        String wife;
        String con;
        blockchain.add(new Block(++n,"Block","Chain","Didi","0"));
        blockchain.add(new Block(++n,"Thanapon Sridi","Taylor Molly","Peyton  Caroline",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Vichai Jumnu"," Brianna Madelyn","Harper Bailey",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Kata Medee","Aaliyah Scarlett","Alexa	 Melanie",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Human Man","Riley Andrea","Makayla Kennedy",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Yuttakarn Somsak","Camila Genesis","Julia Destiny",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Somsak yahoo","Khloe Eva","Kylie  Maria",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Sakarin nahnow","Claire Ariana","Kayla Naomi",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Sakawa Yundun","Sophie Madeline","Bella London",blockchain.get(blockchain.size()-1).Hash));
        blockchain.add(new Block(++n,"Mechai Chaiyo","Arianna Brooke","Katherine Payton",blockchain.get(blockchain.size()-1).Hash));
        
        System.out.println("==============================================================================");
        System.out.println("Input 0 for exit");
        System.out.println("Input 1 for add block");
        System.out.println("Input 2 for edit block");
        System.out.println("==============================================================================");
        do{
              System.out.print("What do you want to do ? :");
              num = sc.nextInt();
              sc.nextLine();
   
        }while(num != 1 && num != 0 && num != 2);
        
        if(num == 1){
             System.out.print("Enter the name of Husband : ");
             hand = sc.nextLine();
             
             System.out.print("Enter the name of Wife : ");
             wife = sc.nextLine();
             
             System.out.print("Enter the name of Registrar : ");
             con = sc.nextLine();
             blockchain.add(new Block(++n,hand,wife,con,blockchain.get(blockchain.size()-1).Hash));
             
             newBlock();
             printBlock();
        }
        else if(num == 2){
            do{
             System.out.print("Enter the number of Block[1-10] for Edit : ");
             x = sc.nextInt();
             sc.nextLine();
             }while(x > 10 || x < 1 );

             System.out.print("Enter the name of Husband : ");
             hand = sc.nextLine();
             
             System.out.print("Enter the name of Wife : ");
             wife = sc.nextLine();
             
             System.out.print("Enter the name of Registrar : ");
             con = sc.nextLine();
             
             newBlock();
             newChain(x,hand,wife,con);
             printBlock();
        }
        else if(num == 0){
             System.out.println("OK You want to exit ");
             newBlock();
             printBlock();
             
        }
        
    }
    
    public static Boolean isChainValid(int x,int y) {
			if (!newchain.get(x).Hash.equals(blockchain.get(y).prevHash) && x != y) {
				System.out.println("Hashes Block "+ newchain.get(x).index +" not equal");
				return false;
			}else if (!newchain.get(x).Hash.equals(blockchain.get(y).Hash) && x == y){
                                System.out.println("Hashes Block "+ newchain.get(x).index +" not equal");
				return false;
                        }
		return true;
	}
    public static void printBlock(){
        int temp = 0;
        System.out.println("============================== Data Block ====================================");
             System.out.println("The block chain :");
        for (int i = 0; i < blockchain.size() -1 ; i++) {
            System.out.println(newchain.get(i));
            System.out.println("Blockchain is Valid: " + isChainValid(i,i+1) + "\n}\n");
            temp = i;
        }
        System.out.println(newchain.get(temp+1));
        System.out.println("Blockchain is Valid: " + isChainValid(temp+1,temp+1) + "\n}\n");
    }
    public static void newBlock(){
        for (int i = 0; i < blockchain.size(); i++) {          
            newchain.add(blockchain.get(i)); 
        }
        
    }
    public static void newChain(int x,String hand,String wife,String con){
        
        for (int i = 0; i < blockchain.size(); i++) {
            if( x != 1){
                if(newchain.get(i).index == x){      
                    newchain.set(i,new Block(i+1,hand,wife,con,blockchain.get(i-1).Hash));
                }else if(newchain.get(i).index > x){
                    newchain.set(i,new Block(i+1,blockchain.get(i).husband,blockchain.get(i).wife,blockchain.get(i).registrar,newchain.get(i-1).Hash));
                }
                else if(newchain.get(i).index < x){
                    newchain.set(i,blockchain.get(i)); 
                }
            }else if (x==1){
                if(newchain.get(i).index == x){      
                    newchain.set(i,new Block(i+1,hand,wife,con,"0"));
                }else if(newchain.get(i).index > x){
                    newchain.set(i,new Block(i+1,blockchain.get(i).husband,blockchain.get(i).wife,blockchain.get(i).registrar,newchain.get(i-1).Hash));
                }
            }
        }
        
    }
}
