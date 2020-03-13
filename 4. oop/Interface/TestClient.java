public class TestClient {
   public static int getVal() {
       return 42;
   }
 
   public static void main(String[] args) {
       C c = new X();	//because interface can be a reference type but not object type
	   c.foo();
	   c.bar();
	   c.foobar();
   }
}