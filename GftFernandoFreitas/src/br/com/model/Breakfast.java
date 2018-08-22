package br.com.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum Breakfast {

	EGGS(1, "Eggs"), TOAST(2, "Toast"), COFFE(3, "coffee");

	public static final String MORNING = "Morning";

	private final int id;

	private final String key;

	private Breakfast(int id, String key) {
		this.id = id;
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public static void printBreakfast() {

		System.out.println("Morning");
		for (Breakfast breakfast : Breakfast.values()) {
			StringBuilder builder = new StringBuilder();
			System.out.println(builder.append(breakfast.getId()).append("-").append(breakfast.getKey()));
		}

		System.out.println("\t");
	}

	public static void printConsultDiet(List<Integer> index) {

		List<Integer> distinctList = index.stream().distinct().collect(Collectors.toList());
		Map<Integer, Integer> repeat = new HashMap<>();

		for (Integer distinct : distinctList) {
			repeat.put(distinct, Collections.frequency(index, distinct));
		}

		Set<Integer> keys = repeat.keySet();
		x: for (Integer key : keys) {
			for (Breakfast breakfast : Breakfast.values()) {
				if (key.equals(breakfast.getId())) {

					if (!key.equals(Breakfast.COFFE.id)) {
						if (repeat.get(key) > 1) {
							System.out.println("the item " + breakfast.getKey() + " can not be repeated");
							break x;
						} else {
							System.out.println(String.format(breakfast.getKey()));
						}
					} else {
						if (repeat.get(key) > 1) {
							System.out.println(String.format(breakfast.getKey() + "(" + repeat.get(key) + ")"));
						} else {
							System.out.println(String.format(breakfast.getKey()));
						}
					}
				}
			}
		}
	}
}
