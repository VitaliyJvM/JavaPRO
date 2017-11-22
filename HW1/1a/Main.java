package mvs;

public class Main {

	public static void main(String[] args) {

		if (Tester.test(MyClass.class)) {
			System.out.println("Compilation successful!");
		} else {
			System.out.println("An error occured!");
		}
		
	}

}
