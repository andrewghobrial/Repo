
public class BN{
	   public int data;//the actual object stored...
	   public int height;
	   public boolean alive;
	   public BN left, right;
	   public BN(int x, BN l, BN r){//constructor
	     data = x;
	     left = l;
	     right = r;
	     alive=true;
	} 
	   }