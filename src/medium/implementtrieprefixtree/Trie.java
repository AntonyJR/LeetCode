package medium.implementtrieprefixtree;

class Trie {
    private boolean endword = false;
    private final Trie[] children = new Trie[26];

    /** Initialize your data structure here. */
    private Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie currchild = this;
        for (int i=0; i<word.length(); i++ ) {
            int first = word.charAt(i) - 'a';
            Trie child = currchild.children[first];
            if (child == null) {
                child = new Trie();
                currchild.children[first] = child;
            }
            child.endword = child.endword || ((i+1)==word.length());
            currchild = child;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie child = this;
        for (int i=0; i<word.length(); i++) {
            int first = word.charAt(i) - 'a';
            child = child.children[first];
            if (child == null) return false;
        }
        return child.endword;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie child = this;
        for (int i=0; i<prefix.length(); i++) {
            int first = prefix.charAt(i) - 'a';
            child = child.children[first];
            if (child == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */