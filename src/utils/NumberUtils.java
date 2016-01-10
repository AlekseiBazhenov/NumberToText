package utils;

import java.util.ArrayList;
import java.util.Collections;

import enums.Range;

public class NumberUtils {

	private NumberUtils() {

	}

	private static NumberUtils numberUtils;

	public static NumberUtils getUtils() {
		if (numberUtils == null) {
			numberUtils = new NumberUtils();
		}
		return numberUtils;
	}

	public Range getRange(int length) {
		int tripletCount = length % 3 > 0 ? length / 3 + 1 : length / 3;
		switch (tripletCount) {
		case 1:
			return Range.HUNDRED;
		case 2:
			return Range.THOUSAND;
		case 3:
			return Range.MILLION;
		case 4:
			return Range.BILLION;
		default:
			return null;
		}
	}

	public int countDigitsInFirstTriplet(int length) {
		int i = length % 3;
		return i == 0 ? 3 : i;
	}

	private ArrayList<String> list;
	private StringBuilder builder;

	public String getTriplet(String value, int index) {
		list = new ArrayList<>();
		builder = new StringBuilder();
		int length = value.length();
		int tripletSize = 3;
		boolean firstTripletAdded = false;

		for (int i = 0; i < length; i++) {
			builder.append(value.charAt(i));
			if (builder.length() == tripletSize) {
				addBuilderToList();
			} else if (builder.length() == countDigitsInFirstTriplet(length)
					&& !firstTripletAdded) {
				addBuilderToList();
				firstTripletAdded = true;
			}
		}
		Collections.reverse(list);
		return list.get(index);
	}

	private void addBuilderToList() {
		list.add(builder.toString());
		builder.setLength(0);
		builder.trimToSize();
	}
}
