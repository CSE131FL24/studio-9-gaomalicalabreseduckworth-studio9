package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		// Create a new HashMap to store word counts
		Map<String, Integer> wordCounts = new HashMap<>();

		// Iterate through the list of words
		for (String word : words) {
			// If the word is already in the map, increment its count
			if (wordCounts.containsKey(word)) {
				wordCounts.put(word, wordCounts.get(word) + 1);
			} else {
				// If the word is not in the map, add it with a count of 1
				wordCounts.put(word, 1);
			}
		}

		return wordCounts; // Return the populated map
	}

	public static void main(String[] args) {
		// Create a list of words
		List<String> wordList = new LinkedList<>();
		wordList.add("to");
		wordList.add("be");
		wordList.add("or");
		wordList.add("not");
		wordList.add("to");
		wordList.add("be");

		// Call countWords to generate the word frequency map
		Map<String, Integer> words = countWords(wordList);

		// Iterate over the map to print its contents
		System.out.println("Word counts:");
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			System.out.println("Word: \"" + entry.getKey() + "\", Count: " + entry.getValue());
		}
	}
}
