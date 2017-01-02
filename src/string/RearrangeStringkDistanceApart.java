package string;

import java.util.*;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
Given a non-empty string str and an integer k,
rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters.
If it is not possible to rearrange the string, return an empty string "".

Example 1:
str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
str = "aaabc", k = 3

Answer: ""

It is not possible to rearrange the string.
Example 3:
str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
 */

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String str, int k) {
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((entry1, entry2) -> ( entry2.getValue() - entry1.getValue()));

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
}
