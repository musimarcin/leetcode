import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            // put every number as key and times it appears as value into hashmap
//            int count = hashMap.getOrDefault(num, 0);
//            hashMap.put(num, count+1);
//        }
//        // create sorted list with amount of repetitions of each number
//        List<Integer> ordered = new ArrayList<>(hashMap.keySet());
//        ordered.sort((a,b) -> hashMap.get(b) - hashMap.get(a));
//        // put k number of selected top numbers
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = ordered.get(i);
//        }
//        return result;

        // BUCKET SORT
        HashMap<Integer, Integer> count = new HashMap<>();
        //bucket with frequencies(as indexes) of each element
        List<Integer>[] bucket = new List[nums.length+1];

        for (int n : nums) count.put(n, count.getOrDefault(n, 0) + 1);
        //loop through keys(numbers) of hashmap and add new list of numbers to bucket to corresponding frequency(index)
        for (int n : count.keySet()) {
            int freq = count.get(n);
            if (bucket[freq] == null) bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        //loop from end of bucket (most frequent numbers) to beginning and add result to res list and
        // decrease k of that much as how many numbers were put into res
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                List<Integer> tmp = bucket[i];
                res.addAll(tmp);
                k -= tmp.size();
            }
        }
        //change list into array
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
}
