package leetcode;

import java.util.*;

public class WordLadder {
	//BFS 119ms
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		wordList.add(endWord);
		List<List<String>> levels = new ArrayList<List<String>>();
		List<String> level = getNeighbors(beginWord, wordList);
		int levelIndex = 0;
		levels.add(levelIndex,level);
		while(!level.isEmpty()){ //O(n) n is the size of the wordList
			List<String> tmp = levels.get(levelIndex);
			level = new ArrayList<String>();
			for(int i = 0; i < tmp.size(); i++){
				String cur = tmp.get(i);
				if(cur.equals(endWord)) return levelIndex+2;

				List<String> nextLevel = getNeighbors(cur,wordList);

				for(String s : nextLevel){
					level.add(s);
					wordList.remove(s);
				}

			}

			if(!level.isEmpty()){
				levelIndex++;
				levels.add(levelIndex,level);
			}

		}

		return levelIndex;
	}

	/*O(k*26) (constant)
    we dont need to spend N^2 time to build the adjacency graph, we just need to compute the neighbors of the current string
    which will only cost constant time
    */
	public static List<String> getNeighbors(String source, Set<String> wordList) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < source.length(); i++){
			for(char ch = 'a'; ch <= 'z'; ch++){
				char[] word = source.toCharArray();
				word[i] = ch;
				String tmp = new String(word);
				if(!tmp.equals(source) && wordList.contains(tmp)){
					result.add(tmp);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");dict.add("b");dict.add("c");
//		dict.add("code");dict.add("lode");dict.add("robe");
//		dict.add("lost");
		int res = ladderLength(start,end,dict);
		System.out.println(res);
	}

}
