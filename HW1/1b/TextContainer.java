package mvs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
@interface SaveTo {
	String path() default "d:\\file.txt";
}

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface SaveMethod {
}

@SaveTo(path="d:\\filetext.txt")
public class TextContainer {

	private String text;

	public TextContainer(String text) {
		super();
		this.text = text;
	}

	public TextContainer() {
		super();
		this.text = "empty";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@SaveMethod
	public void save() {
		
		try {
			Class<TextContainer> cls = TextContainer.class;
			
			SaveTo t = (SaveTo) cls.getAnnotation(SaveTo.class);						
			Saver.save(t.path(), text);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
		
}
