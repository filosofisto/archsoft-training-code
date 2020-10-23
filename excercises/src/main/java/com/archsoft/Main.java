package com.archsoft;

import com.archsoft.imp.*;

import java.util.Arrays;
import java.util.List;

public class Main {
	private static final List<Exercise> EXERCISES = Arrays.asList(
		new Excercise_01(),
		new Excercise_02(),
		new Excercise_03(),
		new Excercise_04(),
		new Excercise_05(),
		new Excercise_06(),
		new Excercise_07(),
		new Excercise_08(),
		new Excercise_09(),
		new Excercise_10(),
		new Excercise_11(),
		new Excercise_12(),
		new Excercise_13(),
		new Excercise_14(),
		new Excercise_15(),
		new Excercise_16(),
		new Excercise_18(),
		new Excercise_19(),
		new Excercise_20(),
		new Excercise_21()
	);

	public static void main(String[] args) {
		EXERCISES.stream().forEach(Exercise::run);
	}
}
