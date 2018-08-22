package br.com.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum Dinner {

	BEEF(1, "Steak"), POTATO(2, "Potato"), WINE(3, "Wine"), CAKE(4, "Cake");

	private final int id;
	private final String key;

	public static final String NIGHT = "Night";

	private Dinner(int id, String key) {
		this.id = id;
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public static void printDinner() {

		System.out.println("Night");
		for (Dinner dinner : Dinner.values()) {
			StringBuilder builder = new StringBuilder();
			System.out.println(builder.append(dinner.getId()).append("-").append(dinner.getKey()));
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
			for (Dinner dinner : Dinner.values()) {
				if (key.equals(dinner.getId())) {

					if (!key.equals(Dinner.POTATO.id)) {
						if (repeat.get(key) > 1) {
							System.out.println("the item " + dinner.getKey() + " can not be repeated");
							break x;
						} else {
							System.out.println(String.format(dinner.getKey()));
						}
					} else {
						if (repeat.get(key) > 1) {
							System.out.println(String.format(dinner.getKey() + "(" + repeat.get(key) + ")"));
						} else {
							System.out.println(String.format(dinner.getKey()));
						}
					}
				}
			}
		}
	}

}
