package com.archsoft.imp;

import com.archsoft.Console;
import com.archsoft.Exercise;

import java.util.function.Consumer;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_21 extends Exercise {

	private static final String DESCRIPTION = "A Pilha é uma estrutura de dados do "
			+ "tipo FILO (first in last out é primeiro a entrar é o último a sair). "
			+ "Implemente em Java usando vetor uma estrutura de pilha com 3 "
			+ "métodos: push (inclui um item na pilha) e pop (remover um item da pilha)";
	
	public Excercise_21() {
		super(DESCRIPTION);
	}
	

	@Override
	protected void doRun() {

		Stack<Integer> stack = new Stack<>(10);
		stack.push(1);
		stack.push(2);
		stack.push(6);
		stack.push(3);
		stack.push(-1);
		stack.push(9);
		stack.push(5);
		Console.println("Pilha atual");
		stack.foreach(Console::println);
		Console.println("Desempilhado " + stack.pop());
		stack.foreach(Console::println);
		Console.println("Desempilhado " + stack.pop());
		stack.foreach(Console::println);
		Console.println("Desempilhado " + stack.pop());
		stack.foreach(Console::println);
	}
}

final class Stack<T> {
	
	private static final int DEFAULT_LENGTH = 100;

	private int count = 0;
	private Object[] stack;
	
	public Stack() {
		this(DEFAULT_LENGTH);
	}
	
	@SuppressWarnings("unchecked")
	public void foreach(Consumer<T> c) {
		for(int i = 0; i < count; i++) {
			c.accept((T)stack[i]);
		}
	}

	public Stack(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Unabled to define a negative stack size");
		this.stack = new Object[size];
	}
	
	public void push(T value) {
		if (count == stack.length)
			throw new IllegalStateException("Stack overflow");
		this.stack[count++] = value;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		if (isEmpty())
			throw new IllegalStateException("Unabled to pop empty stack");
		return (T)stack[--count];
	}

	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
}
