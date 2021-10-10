package Others;

import java.util.*;

/*    String[] findSubstrings(String[] words, String[] parts) {
        Trie t = new Trie(parts);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int longest = -1;
            int startIdx = 0;
            for (int j = 0; j < word.length(); j++) {
                int index = t.search(word.substring(j));
                if (index != -1 && index > longest) {
                    longest = index;
                    startIdx = j;
                }
                if (longest > word.length() - j)
                    break;
            }
            if(longest > -1)
                words[i] = new StringBuilder(word).insert(startIdx, '[').insert(startIdx + longest + 1, ']').toString();  
        }
        return words;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        TrieNode() {
        }
    }
    class Trie {
        TrieNode root;
        Trie(String[] array) {
            root = new TrieNode();
            for (String s : array) {
                insert(s);
            }
        }
        
        public void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                cur.children.computeIfAbsent(ch, k -> new TrieNode());
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }
        
        public int search(String s) {
            TrieNode cur = root;
            int result = -1;
            for(int i = 0; cur != null && i < s.length(); i++) {
                cur = cur.children.get(s.charAt(i));
                if (cur != null && cur.isWord) {
                    result = i + 1;
                }
            }
            return result;
        }
    }*/

public class Trie {
	
	public class TrieNode {
		Map<Character, TrieNode> map;
		boolean isEnd;
		
		public TrieNode() {
			map = new HashMap<>();
			isEnd = false;
		}
		
		public void insert(String word) {
			
			TrieNode node = this;
			
			for (int i = 0 ; i < word.length(); i++) {
				if(!node.map.containsKey(word.charAt(i))) {
					node.map.put(word.charAt(i), new TrieNode());
				}
				node = node.map.get(word.charAt(i));
				
			}
			
			node.isEnd = true;
			
			
		}
		
		public boolean contains(String word) {
			TrieNode node = this;
			for (int i = 0; i < word.length(); i++) {
				if(node.map.containsKey(word.charAt(i))) {
					node = node.map.get(word.charAt(i));
				}
				else {
					return false;
				}
			}
			
			return node.isEnd == true;
		}
	}
	
	
	
	
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"the", "thee"};
        
        System.out.println(isPresent(keys, output[0]));
        System.out.println(isPresent(keys, output[1]));
        System.out.println(isPresent(keys, "ans"));
        System.out.println(isPresent(keys, "any"));
    }




	private static boolean isPresent(String[] keys, String str) {
		
		Trie trie = new Trie();
		
		TrieNode node = trie.new TrieNode();
		
		for (String key: keys) {
			node.insert(key);
		}
		
		
		
		return node.contains(str);
		
	}

}
