package annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Column {
	public String field();
	public boolean primaryKey() default false;
	public String type() default "VARCHAR(80)";
	public boolean defaultNull() default true;//是否允许为空
}
