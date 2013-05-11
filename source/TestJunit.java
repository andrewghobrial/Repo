
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
	
   DynamicDict avlTree = new DynamicDict();
   int number = 44;
   @Test
   public void testFind() {
	  avlTree.insert(number);
      assertEquals(true,avlTree.find(number));
   }
   @Test
   public void testCount() {
	   avlTree.insert(number);
	   assertEquals(1,avlTree.count());
   }
   @Test
   public void testRemove() {
	   avlTree.insert(number);
	   avlTree.remove(number);
	   assertEquals(0,avlTree.count());
   }
}