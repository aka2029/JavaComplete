public class X extends AbstractA implements A, B, C {
   public void foo() {
	   System.out.println("X: foo");
	   System.out.println("VAL: " + B.VAL);
   }
   public void foobar() {
	   System.out.println("X: foobar");
   }
}