package com.k2view.quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find maximum occurring word in given set of strings
 * Given a huge set of strings with duplicate strings present, find the maximum occurring word in it. 
 * If two words have same count, return any one of them.
 * The idea is to solve this problem. We start by inserting each key into the trie and store its count 
 * so far (along with the key itself) in the leaf nodes. 
 * After all nodes are inserted into the trie, we perform its pre-order traversal (depth first search) and 
 * find maximum frequency word by comparing the count present at leaf nodes. 
 * Note that we can also use a map to solve this problem.
 * @author Peter
 *
 */
public class MaxOccuringWord {

	// A class representing a Trie node
	public static class TrieNode {
		// count and key will be set only for leaf nodes
		// key stores the string and count stores its frequency so far
		String key;
		int count;

		// each node stores a map to its child nodes
		Map<Character, TrieNode> character = null;

		// Constructor
		TrieNode() {
			character = new HashMap<>();
		}
	};


	public static class Util {
		// Iterative function to insert a String in TrieNode
		public static void insert(TrieNode head, String str) {
			// start from root node
			TrieNode curr = head;

			for (int i = 0; i < str.length(); i++) {
				// create a new node if path doesn't exists
				if (!curr.character.containsKey(str.charAt(i))) {
					curr.character.put(str.charAt(i), new TrieNode());
				}

				// go to next node
				curr = curr.character.get(str.charAt(i));
			}

			// store key and its count in leaf nodes
			curr.key = str;
			curr.count += 1;
		}

		// Function to perform pre-order traversal of given TrieNode
		// and find word with maximum frequency
		public static int preOrder(TrieNode curr, int maxCount, StringBuilder key) {
			// return false if TrieNode is empty
			if (curr == null) {
				return maxCount;
			}

			for (Map.Entry<Character, TrieNode> entry: curr.character.entrySet()) {
				// leaf node have non-zero count
				if (maxCount < entry.getValue().count) {
					key.replace(0, key.length(), entry.getValue().key);
					maxCount = entry.getValue().count;
				}

				// recurse for current node children
				maxCount = preOrder(entry.getValue(), maxCount, key);
			}

			return maxCount;
		}
	}

	public static void main(String[] args) {
		// given set of keys
		List<String> dict = Arrays.asList(
				"code", "coder", "coding", "codable", "codec", "codecs", "coded",
				"codeless", "codec", "codecs", "codependence", "codex", "codify",
				"codependents", "codes", "code", "coder", "codesign", "codec",
				"codeveloper", "codrive", "codec", "codecs", "codiscovered"
				);

		// Insert all keys into a trie
		TrieNode head = new TrieNode();
		for (String word : dict) {
			Util.insert(head, word);
		}

		int count = 0;
		StringBuilder key = new StringBuilder();

		// perform pre-order traversal of given TrieNode and find key
		// with maximum frequency
		count = Util.preOrder(head, count, key);

		System.out.println("Word : " + key);
		System.out.println("Count: " + count);
	}

}
