package com.archsoft;

/**
 * Exemplo demonstrando @Override
 * 
 * @author eduardo
 *
 */
public class MySubclass {

	/*@Override //a anotacao causa erro de compilacao
	public boolean equals(MySubclass other) {
		return false;
	}*/

	@Override 
	public boolean equals(Object obj) {
		return false;
	}
}
