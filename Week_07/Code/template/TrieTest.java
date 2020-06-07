package template;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    @Test
    public void testTrie(){
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertTrue(trie.startsWith("app"));
        Assert.assertFalse(trie.search("app"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }
}
