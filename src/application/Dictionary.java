package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {
	
	
	private List<String> words;
	private Map<String, String> translations;
	
	public Dictionary() {
		this.words = new ArrayList<>();
		this.translations = new HashMap<>();
		
		add("mot", "word");
	}
	
	public String get(String word) {
		return this.translations.get(word);
	}
	
	public void add(String word, String translation) {
		if (!this.translations.containsKey(word)) {
		this.translations.put(word, translation);
		this.words.add(word);
		}
	}
	
	public String getRandom() {
		Random random = new Random();
		return this.words.get(random.nextInt(words.size()));
		
	}
}
