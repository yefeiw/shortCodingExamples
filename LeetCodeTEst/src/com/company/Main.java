package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution sol = new Solution();
        String input = "gpneqthatplqrofqgwwfmhzxjddhyupnluzkkysofgqawjyrwhfgdpkhiqgkpupgdeonipvptkfqluytogoljiaexrnxckeofqojltdjuujcnjdjohqbrzzzznymyrbbcjjmacdqyhpwtcmmlpjbqictcvjgswqyqcjcribfmyajsodsqicwallszoqkxjsoskxxstdeavavnqnrjelsxxlermaxmlgqaaeuvneovumneazaegtlztlxhihpqbajjwjujyorhldxxbdocklrklgvnoubegjrfrscigsemporrjkiyncugkksedfpuiqzbmwdaagqlxivxawccavcrtelscbewrqaxvhknxpyzdzjuhvoizxkcxuxllbkyyygtqdngpffvdvtivnbnlsurzroxyxcevsojbhjhujqxenhlvlgzcsibcxwomfpyevumljanfpjpyhsqxxnaewknpnuhpeffdvtyjqvvyzjeoctivqwann";

        String answer = sol.reorganizeString(input);
        System.out.println("Answer is \n" + answer);

    }


}

class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        int[] cnt = new int[26];
        for (int i = 0; i < S.length(); i ++) {
            cnt[S.charAt(i) - 'a'] ++;
        }
        Comparator<Integer> myComparator = new Comparator<Integer>(){
            public int compare(Integer i, Integer j) {
                if (cnt[j] > cnt[i]) {
                    return 1;
                } else if (cnt[j] == cnt[i]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<Integer> sort = new PriorityQueue<>(myComparator);
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] != 0) {
                sort.add(i);
            }
        }
        char[] data = new char[n];
        boolean turn = true;
        while (!sort.isEmpty()) {
            int index = sort.remove();
            if (turn) {
                int i = 0;
                while (cnt[index] > 0) {
                    while (i < n && data[i] != '\u0000') {
                        i ++;
                    }
                    if (i >= n) {
                        return "";
                    }
                    data[i] = (char) (index + 'a');
                    i += 2;
                    cnt[index] --;
                }
                turn = false;
            } else {
                int i = n - 1;
                while (cnt[index] > 0) {
                    while (i >= 0 && data[i] != '\u0000') {
                        i --;
                    }
                    if (i < 0) {
                        return "";
                    }
                    data[i] = (char) (index + 'a');
                    i -= 2;
                    cnt[index] --;
                }
                turn = true;
            }
        }
        return new String(data);
    }
}
