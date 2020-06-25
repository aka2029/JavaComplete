package lecturew18;

import java.util.ArrayList;

class A {

}

class B extends A {

}

class C extends B {

}

class D {

}

public class GenericProblem {

	static void print2(A[] list) {

	}

	static void print(ArrayList<A> list) {

	}

	static void print3(ArrayList<?> list) {

	}

	// extends , super ,? - wild card
	static void print5(ArrayList<? extends A> list) {

	}

	static void print4(ArrayList<Object> list) {

	}

	public static void main(String[] args) {
		A a[] = new A[10];
		a[0] = new A();
		a[1] = new B();
		a[2] = new C();
		B b[] = new B[10];
		ArrayList ll = new ArrayList();
		ArrayList<B> l = new ArrayList<>();
		ArrayList<D> l2 = new ArrayList<>();
		// print5(l2);
		l.add(new B());
		// print(l);
		print2(b);

		D d[] = new D[10];
		// print2(d);
	}
}
