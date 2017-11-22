package mvs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyTest {

	int a();
	int b();

}

public class MyClass {
	
	@MyTest(a=3, b=5)
	public static void test(int a, int b) {
		System.out.println("Sum = " + (a + b));
	}
	
}
