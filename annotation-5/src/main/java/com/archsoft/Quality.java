package com.archsoft;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Quality {

	enum Level { BAD, INDIFFERENT, GOOD }
	
	Level value() default Level.INDIFFERENT;
}
