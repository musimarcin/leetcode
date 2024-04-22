import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            // put every number as key and times it appears as value into hashmap
            int count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, count+1);
        }
        // create sorted list with amount of repetitions of each number
        List<Integer> ordered = new ArrayList<>(hashMap.keySet());
        ordered.sort((a,b) -> hashMap.get(b) - hashMap.get(a));
        // put k number of selected top numbers
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ordered.get(i);
        }
        return result;
    }
}
