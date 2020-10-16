package com.archsoft;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExportadorXML {

	private StringBuilder buf;
	
	public ExportadorXML() {
		buf = new StringBuilder();
	}
	
	public ExportadorXML cabecalho() {
		buf.append("<?xml version=\"1.0\"?>\n");
		
		return this;
	}
	
	public String exportar(List<?> list) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String pluralClassName = plural(list);

		buf.append(
			"<" + pluralClassName + ">\n"
		);
		
		for (Object obj: list) {
			buf.append("\t" + exportar(obj) + "\n");
		}
		
		buf.append(
			"</" + pluralClassName + ">\n"
		);
		
		String ret = buf.toString();
		buf.setLength(0);

		return ret;
	}

	private String plural(List<?> list) {
		Objects.requireNonNull(list);

		return Optional.of(list)
				.map(l -> l.get(0).getClass().getSimpleName().toLowerCase() + "s" )
				.orElse("Unnamed");

//		Objects.requireNonNull(list);
//
//		if (list.isEmpty()) {
//			return "unamed";
//		}
//
//		return list.get(0).getClass().getSimpleName().toLowerCase() + "s";
	}

	private String exportarObj(Object obj) 
			throws NoSuchMethodException, 
				SecurityException, 
				IllegalAccessException, 
				IllegalArgumentException, 
				InvocationTargetException {
		Class cls = obj.getClass();
		
		buf.append(
			"\t<" + cls.getSimpleName().toLowerCase() + ">\n"
		);
		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field: fields) {
			buf.append("\t\t<" + field.getName() + ">");
			
			Method getter = getter(cls, field);
			Object value = getter.invoke(obj);
			
			if (value != null) {
				buf.append(value);
			}
			
			buf.append("</" + field.getName() + ">\n");
		}
		
		buf.append(
			"\t</" + cls.getSimpleName().toLowerCase() + ">"
		);
		
		return buf.toString();
	}
	
	public String exportar(Object obj) 
			throws IllegalArgumentException, 
				IllegalAccessException, 
				NoSuchMethodException, 
				SecurityException, 
				InvocationTargetException {
		StringBuilder buf = new StringBuilder();

		Class cls = obj.getClass();
		
		buf.append(
			"\t<" + cls.getSimpleName().toLowerCase() + ">\n"
		);
		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field: fields) {
			buf.append("\t\t<" + field.getName() + ">");
			
			Method getter = getter(cls, field);
			Object value = getter.invoke(obj);
			
			if (value != null) {
				buf.append(value);
			}
			
			buf.append("</" + field.getName() + ">\n");
		}
		
		buf.append(
			"\t</" + cls.getSimpleName().toLowerCase() + ">"
		);
		
		return buf.toString();
	}
	
	private Method getter(Class cls, Field field) 
			throws NoSuchMethodException, SecurityException {
		return cls.getMethod(
				"get"
				+ field.getName().substring(0,1).toUpperCase()
				+ field.getName().substring(1));
	}
}
