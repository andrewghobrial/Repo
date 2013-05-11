
public class DynamicDict {
	  private BN root;
	  int count;
	  public DynamicDict(){
		  root = null; 
		  count = 0;
	}
	  public boolean find(int k){return find(k,root);}
	  private boolean find(int k, BN n){
		    if (n == null) return false;
		    if (k == n.data) return true;
		    if (k< n.data) return find(k,n.left);
		    return find(k, n.right);
		}
	  public void insert(int d) {
		 root=insert(root,d); count++;
		 return;
	  }
	  private BN insert(BN t, int d){
		    if (t == null) return new BN(d, null, null);
		    if (t.alive==false) return new BN(d, null, null);
		    if (d <= t.data)  t.left = insert(t.left, d);
		       else t.right = insert(t.right,d);
		   //Rebalance
		   int leftHeight   =  (t.left == null)   ? -1 : t.left.height;
		   int rightHeight = (t.right == null) ? -1 : t.right.height;
		   if (leftHeight > rightHeight + 1){//LL or LR
		      if (d < t.left.data){ //LL
		    	  BN newNode = t.left;
		            t.left = newNode.right;
		            newNode.right = t;
		            t=newNode;
		      } else{
		     //LR 
		    	//  rotate left child with its right child:
		    	  BN newNode = t.left.right;
		            t.left.right = newNode.left;
		            newNode.left = t.left;
		            t.left=newNode;
		         //   rotate left child with its root:
		            BN newNode2 = t.left;
		            t.left = newNode2.right;
		            newNode2.right = t;
		            t=newNode2;
		    	  }
		   }
	   if (leftHeight < rightHeight - 1){//RR or RL
		      if (d > t.right.data){
		    	  BN newNode = t.right;
		            t.right = newNode.left;
		            newNode.left = t;
		            t=newNode;
		    	  }
		    	  else{ //RL
		    		//  rotate right child with its left child:
			    	  BN newNode = t.right.left;
			            t.right.left = newNode.right;
			            newNode.right = t.right;
			            t.right=newNode;
			         //   rotate right child with its root:
			            BN newNode2 = t.right;
			            t.right = newNode2.left;
			            newNode2.left = t;
			            t=newNode2;
			    	  
		    	  }
	   }
		   //Update t’s height fields
		   t.height=height(t);
		   if(t.left!=null) t.left.height=height(t.left);
		   if(t.right!=null) t.right.height=height(t.right);
		   return t; 
	  }
	  private int height(BN t) {
		  int h;
		  if(t==null) return -1;
		  if((t.left==null)&&(t.right==null)) {h=0;};
		  if((t.left!=null)&&(t.right==null)) {h=height(t.left)+1;}
		  if((t.left==null)&&(t.right!=null)) {h=height(t.right)+1;}
		  h=(1+Math.max(height(t.left), height(t.right)));
		  return h;
	  }
	  public void remove(int k) {
		  remove(k,root);
	  }
	  private void remove(int k, BN n) { //lazy delete
		  boolean ifExists = find(k,n);
		  if (ifExists==false) return;
		  if (k == n.data) {n.alive=false; count--; return;}
		  if (k< n.data) {remove(k,n.left); return;}
		  remove(k, n.right);
	      return;
	  }
	  public int count() {
		  return count;
	  }
}
