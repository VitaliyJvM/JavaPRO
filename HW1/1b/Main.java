package mvs;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		TextContainer tc = new TextContainer();
		
		tc.setText("Hello world!");
		if (doJob(tc)) {
			System.out.println("Done!");
		} else {
			System.out.println("Bad!");
		}
		
	}
	
	public static boolean doJob(TextContainer tc) {
		
		try {
				Method[] methods = tc.getClass().getDeclaredMethods();
				boolean isAn = false;
				for (Method method : methods) {
					if (method.isAnnotationPresent(SaveMethod.class)) {
						isAn = true;						
						method.invoke(tc);
					}
				}
				if (!isAn) {
					return false;
				}
			
			return true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
