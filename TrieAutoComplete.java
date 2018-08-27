
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
 
/*
 * Auto-complete using tries in java
 */
public class TrieAutoComplete {
   
  public TrieNode root;
  public TrieAutoComplete(){
    root = new TrieNode(' ');
  }
   
  public void insertInTrie(String str){
    int strLen = str.length();
    if (strLen == 0) {
      root.isEndOfString = true;
    } else {
      int i=0;
      TrieNode current = root, child=null;
      while (i < strLen){
        child = current.subNode(str.toLowerCase().charAt(i));
        if (child == null){
          child = new TrieNode(str.toLowerCase().charAt(i));
          current.child.add(child);
        }
        current = child;
        i++;
      }
      current.isEndOfString  = true;
      current.leafNodeStr = str.toLowerCase();
    }
  }
   
  public TrieNode getLocationOfStringInTrie(String str){
    TrieNode current = this.root, child;
    int strLen = str.length();
    int i=0;
    while(i<strLen){
      child = current.subNode(str.toLowerCase().charAt(i));
      if (child != null) {
        current = child;
      } else {
        return null;
      }
      i++; 
    }
    if ( i == strLen){
      return current;
    }
    return null;
  }
   
  public void autocomplete(TrieNode node){
     
    if (node.isEndOfString) {
      System.out.println("-"+node.leafNodeStr);
    }
    for (TrieNode childNode : node.child){
      autocomplete(childNode);
    }
         
  }
   
  public boolean searchInTrie(String str){
    int strLen = str.length();
    if (strLen == 0){
      return true;
    }else {
      int i=0;
      TrieNode current = root, child =  null;
      while (i<strLen) {
        child = current.subNode(str.charAt(i));
        if (child != null) {
          current = child;
        }else {
          return false;
        }
        i++;
      }
      if (i == strLen) {
        return true;
      }
    }
    return false;
  }
     
  public class TrieNode {
    public char data;
    public boolean isEndOfString;
    public Collection<TrieNode> child;
    public String leafNodeStr;
     
    public TrieNode(char data){
      this.data = data;
      child = new LinkedList<TrieNode>();
      this.isEndOfString = false;
    }
     
    public TrieNode subNode(char data){
      if (child != null) {
        for (TrieNode childNode : child) {
          if (childNode.data == data){
            return childNode;
          }
        }
      }
      return null;
    }
  }
   
  public static void main(String[] args) throws IOException {
	TrieAutoComplete trie = new TrieAutoComplete();
    trie.insertInTrie("analyse");
    trie.insertInTrie("boondock");
    trie.insertInTrie("extend");
    trie.insertInTrie("append");
    trie.insertInTrie("insert");
    trie.insertInTrie("remove");
    trie.insertInTrie("free");
    trie.insertInTrie("Free weblog publishing tool from Google, for sharing text, photos and vide");
    trie.insertInTrie("clear");
    trie.insertInTrie("blog");
    trie.insertInTrie("what is autocomplete");
    trie.insertInTrie("blog is your best bet for a voice among the online crowd");
    trie.insertInTrie("start a WordPress blog or create a free website in seconds");
    trie.insertInTrie("start");
    trie.insertInTrie("While we hope these tips are informative, we are unable to answer individua");
    trie.insertInTrie("while");        
    trie.insertInTrie("base ment");
     
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);
    String line;
    TrieNode location = null;
    System.out.println("Enter your keywords::");
    while (true) {
      line = br.readLine();
      if (line.equals("Y")){
        break;
      }
      location = trie.getLocationOfStringInTrie(line);
      if (location != null){
        trie.autocomplete(location);
      }else {
        System.out.println("No Match found for [ "+line+" ] in our data base");
      }
       
    }
     
  }
 
}
