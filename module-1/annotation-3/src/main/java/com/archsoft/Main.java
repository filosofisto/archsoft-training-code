package com.archsoft;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		try {
			MyAnnotadedClass clazz = new MyAnnotadedClass();

			RequestForEnhancement annot =
					clazz.getClass().getAnnotation(RequestForEnhancement.class);

			out.printf("Anotacao da Classe: id=%d, synopsis=%s, engineer=%s, date=%s\n",
					annot.id(), annot.synopsis(), annot.engineer(), annot.date());

			RequestForEnhancement annotMethod =
				clazz.getClass().getField("valor").getAnnotation(RequestForEnhancement.class);

			out.printf("Anotacao do metodo: id=%d, synopsis=%s, engineer=%s, date=%s",
					annotMethod.id(), annotMethod.synopsis(), annotMethod.engineer(), annotMethod.date());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

	}
}
