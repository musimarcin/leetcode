import java.util.HashMap;
import java.util.Objects;

public class Problem76v2 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }
        int left = 0;
        int len = Integer.MAX_VALUE;
        String result = "";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c,0) + 1);
        }
        int have = 0;
        int need = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && Objects.equals(hashMap.get(c), tMap.get(c))) {
                have += 1;
            }
            while (have == need) {
                if (right - left + 1 < len) {
                    result = s.substring(left, right + 1);
                    len = right - left + 1;
                }
                char cl = s.charAt(left);
                hashMap.put(cl, hashMap.getOrDefault(cl, 0) - 1);
                if (tMap.containsKey(cl) && hashMap.get(cl) < tMap.get(cl)) {
                    have -= 1;
                }
                left += 1;
            }
        }
        return len == Integer.MAX_VALUE ? "" : result;
    }
}
