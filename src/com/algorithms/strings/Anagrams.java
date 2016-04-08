package com.algorithms.strings;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class Anagrams {

	/*
	 * Generate the histogram given a string.
	 * The generated histogram is sorted based on the characters
	 * 
	 * For instance : dddab will result in a1b1d3
	 */
	public static String generateHistogram(String s) {
		
		Map<Character, Integer> histogram = Maps.newTreeMap();
		for (char c : s.toCharArray()) {
			Integer old_value = histogram.get(c);
			if (old_value == null) {
				histogram.put(c, 1);
			} else {
				histogram.put(c, ++old_value);
			}
		}
		
		StringBuilder hist_string = new StringBuilder();
		for (Entry<Character, Integer> entry : histogram.entrySet()) {
			hist_string.append(entry.getKey()).append(entry.getValue());
		}
		return hist_string.toString();
	}

	/*
	 * Iterates over the list of strings and groups the anagrams based on the histogram of the
	 * individual strings as the key
	 * 
	 * For instance:
	 * 
	 * abc, bca, cba are all anagrams
	 */
	public void matchAnagrams(List<String> strings) {
		Multimap<String, String> anagram_map = Multimaps.index(strings, new Function<String, String>() {

			@Override
			public String apply(String input) {
				return Anagrams.generateHistogram(input);
			}
		});
		
		System.out.println("Anagrams : ");
		for (Entry<String, Collection<String>> anagrams : anagram_map.asMap().entrySet()) {
			System.out.printf("Key : %s, Values : %s\n", anagrams.getKey(), anagrams.getValue().toString());
		}
		
	}
	
	/**
	 * Expected O/P:
	 * a3b1c1d4
	 * 
	 * Anagrams:
	 * Key : a2k1n1r1, Values : [karan, arank, ranak]
	 * Key : a1d1l1n1o1p1, Values : [poland, dnalop]
	 * Key : a1b1c1, Values : [abc, cba, bac]
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(Anagrams.generateHistogram("dddabcdaa"));
		Anagrams a = new Anagrams();
		a.matchAnagrams(Lists.newArrayList("karan", "arank", "poland", "dnalop", "ranak", "abc", "cba", "bac"));
	}

}
