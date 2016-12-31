package SortAndHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xuanwang on 11/19/16.
 */
public class SortCharsByFrequency {
    public static String frequencySort(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) {
            freq[ch]++;
        }
        TreeMap<Integer, List<Character>> tree = new TreeMap<>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                tree.putIfAbsent(freq[i], new LinkedList<>());
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!tree.isEmpty()) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(frequencySort("tree"));
    }
}
