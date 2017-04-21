import java.io.*;
import java.util.*;

class HashEntry {
      private String key;
      private String value;
 
      HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
      }     
 
      public String getKey() {
            return key;
      }
 
      public String getValue() {
            return value;
      }
	  
	  public void setValue(String value) {
            this.value = value;
      }
}

public class MyHashtable<K, V> {    
    HashEntry[] map = new HashEntry[1000];
	static int counter;
	
	public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>()).run();
    }
    
    public void put(K key, V value) {
        boolean found = false;
		if (key != null) {
			for (int i = 0; i < counter; i++) {
				if (map[i].getKey() == key) {
					map[i].setValue(value.toString());
					found = true;
					break;
				}
			}
			if (!found) {
				map[counter] = new HashEntry(key.toString(), value.toString());
				counter++;
			}
		}
    }

    public String get(K key) {
		String value = null;
        if (key == null)
			return null;
		else {
			for (int i = 0; i < counter; i++) {
				if (map[i].getKey().equals(key)) {
					value = map[i].getValue();
				}
			}
			return value;
		}
    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}