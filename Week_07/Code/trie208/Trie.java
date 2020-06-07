package trie208;

/**
 * 字典树
 *
 */
class Trie {
    private static class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        private TrieNode() {
            this.links = new TrieNode[R];
        }

        private boolean containKey(char ch) {
            return links[ch - 'a'] != null;
        }

        private TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        private void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        private void setEnd(boolean end) {
            isEnd = end;
        }

        private boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * 时间复杂度：O(m)，其中 m 为键长。
     * 空间复杂度：O(m)，其中 m 为键长。
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }

        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * 时间复杂度：O(m)，其中 m 为键长。
     * 空间复杂度：O(1)。
     * @param word
     * @return
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
