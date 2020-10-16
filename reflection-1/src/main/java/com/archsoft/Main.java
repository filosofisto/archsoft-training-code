package com.archsoft;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		//Pessoa p = new Pessoa();
		//Class c = p.getClass();
		
		try {
			Class clsPessoa = Class.forName("com.archsoft.Pessoa");
			Pessoa oPessoa = (Pessoa) clsPessoa.getConstructor().newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		//String s = "sou um objeto";
//		Object b = new Object();
		Pessoa b = new Pessoa();
		Class c = b.getClass();
		
		out.printf("Nome: %s\nNome simples: %s\n",
				c.getName(), c.getSimpleName());
		
		Field[] fields = c.getDeclaredFields();
		for (Field f: fields) {
			out.printf("%s: %s\n", f.getName(), f.getType().getSimpleName());
		}
		
		Constructor[] constructors = c.getConstructors();
		out.println("Construtores ==================== "
				+ constructors.length);
		for (Constructor constr: constructors) {
			for (Class paramClass: constr.getParameterTypes()) {
				out.printf("%s, ", paramClass.getName());
			}
			out.println();
		}
		
		Method[] methods = c.getDeclaredMethods();
		out.println("Metodos ==================== " + methods.length);
		
		for (Method m: methods) {
			out.printf("%s %s\n", m.getReturnType().getName(), m.getName());
			
			if (m.getName().equals("length")) {
				try {
					Integer tamanho = (Integer) m.invoke(b);
					out.printf("%d\n", tamanho);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//System.out.printf("Superclass: %s\n", c.getSuperclass().getName());
		
		Class[] interfaces = c.getInterfaces();
		out.println("Interfaces ================== "
				+ interfaces.length);
		for (Class intf: interfaces) {
			out.printf("%s ", intf.getSimpleName());
		}
	}
}
