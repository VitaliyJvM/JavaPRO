package mvs;

import java.lang.reflect.Method;

public class Tester {
	
	public static boolean test(Class<?>... ls) {
		try {
			
			for (Class<?> cls : ls) {
				Method[] methods = cls.getDeclaredMethods();
				boolean isAn = false;
				for (Method method : methods) {
					if (method.isAnnotationPresent(MyTest.class)) {
						isAn = true;
						MyTest t = method.getAnnotation(MyTest.class);						
						method.invoke(null, t.a(), t.b());
					}
				}
				if (!isAn) {
					System.out.println("Annotation is not present!");
				}
			}
			
			return true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
