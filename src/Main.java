import java.util.*;

public class Main {
    public static void main(String[] args) {
        DailyChallenge dailyChallenge = new DailyChallenge();
        int[][] board = new int[2][3];
        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 3;
        board[1][0] = 4;
        board[1][1] = 0;
        board[1][2] = 5;
        dailyChallenge.slidingPuzzle(board);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean r;

        public TrieNode() {
            children = new HashMap<>();
            r = false;
        }
    }
    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                trie.children.putIfAbsent(c, new TrieNode());
                trie = trie.children.get(c);
            }
            trie.r = true;
        }

    }
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }


// ARRAYS & HASHING
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) bucket.add(new ArrayList<>());
        for (int num : map.keySet()) {
            int freq = map.get(num);
            bucket.get(freq).add(num);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = bucket.size() - 1; i >= 0 && k >= 0; i--) {
            if (!bucket.get(i).isEmpty()) {
                tmp.addAll(bucket.get(i));
                k--;
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) res[i] = tmp.get(i);
        return res;
    }
    public int[] topKFrequentHeap(int[] nums, int k) {
        if (k == nums.length) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = heap.poll();
        return res;
    }
// TWO POINTER
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int x = nums[l] + nums[r] + nums[i];
                if (x < 0) l++;
                else if (x > 0) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return res;
    }
// LINKED LISTS
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) node.next = list1;
        else node.next = list2;
        return dummy.next;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);
        ListNode first = head;
        while (first != null && second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow  = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!visited.add(cur)) return true;
            cur = cur.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return new ListNode().next;
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists2helper(lists, 0, lists.length - 1);
    }
        public ListNode mergeKLists2helper(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l + 1 == r) return mergeTwoLists(lists[l], lists[r]);
        int m = l + (r - l)/2;
        ListNode left = mergeKLists2helper(lists, l, m);
        ListNode right = mergeKLists2helper(lists, m + 1, r);
        return mergeTwoLists(left, right);
    }
    public ListNode mergeKListsPQ(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(
                ((a,b) -> a.val - b.val)
        );
        for (ListNode ln : lists) if (ln != null) minheap.add(node);
        while (!minheap.isEmpty()) {
            ListNode min = minheap.poll();
            node.next = min;
            node = node.next;
            if (min.next != null) minheap.add(min.next);
        }
        return dummy.next;
    }
// TREES
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode cur = new TreeNode(root.val);
        cur.left = invertTree(root.right);
        cur.right = invertTree(root.left);
        return cur;
    }
    public int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res++;
        }
        return res;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (true) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
    }
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qsize = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < qsize; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(tmp);
        }
        return res;
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        levelOrderDFShelper(root, res, 0);
        return res;
    }
        public void levelOrderDFShelper(TreeNode node, List<List<Integer>> res, int height) {
        if (node == null) return;
        if (height >= res.size()) res.add(new ArrayList<>());
        res.get(height).add(node.val);
        levelOrderDFShelper(node.left, res, height + 1);
        levelOrderDFShelper(node.right, res, height + 1);
    }
    public boolean isValidBSTDFS(TreeNode root) {
        return isValidBSTDFSh(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
        public boolean isValidBSTDFSh(TreeNode node, double min, double max) {
            if (node == null) return true;
            if (!(node.left.val > min && node.right.val < max)) return false;
            return isValidBSTDFSh(node.left, min, node.val) && isValidBSTDFSh(node.right, node.val, max);
        }
    public boolean isValidBSTBFS(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (prev != null && cur.val <= prev.val) return false;
            prev = cur;
            cur = cur.right;
        }
        return true;
    }
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2DFS(root, null, null);
    }
        public boolean isValidBST2DFS(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return isValidBST2DFS(node.left, min, node.val) && isValidBST2DFS(node.right, node.val, max);
    }
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            k--;
            if (k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
    public int kthSmallestDFS(TreeNode root, int k) {
        int[] res = {-1, 0};
        kthSmallestDFShelper(root, k, res);
        return res[0];
    }
        public void kthSmallestDFShelper(TreeNode node, int k, int[] res) {
            if (node == null) return;
            kthSmallestDFShelper(node.left, k, res);
            res[1]++;
            if (res[1] == k) {
                res[0] = node.val;
                return;
            }
            kthSmallestDFShelper(node.right, k, res);
        }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int m = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                m = i;
                break;
            }
        }
        int[] lp = Arrays.copyOfRange(preorder, 1, m + 1);
        int[] li = Arrays.copyOfRange(inorder, 0, m);
        root.left = buildTree(lp, li);
        int[] rp = Arrays.copyOfRange(preorder, m + 1, preorder.length);
        int[] ri = Arrays.copyOfRange(inorder, m + 1, inorder.length);
        root.right = buildTree(rp, ri);

        return root;
    }
    public int maxPathSum(TreeNode root) {
        int[] res = {0};
        maxPathSumDFS(root, res);
        return res[0];
    }
        public int maxPathSumDFS(TreeNode node, int[] res) {
            if (node == null) return 0;
            int l = Math.max(maxPathSumDFS(node.left, res), 0);
            int r = Math.max(maxPathSumDFS(node.right, res), 0);
            res[0] = Math.max(res[0], node.val + l + r);
            return Math.max(l, r) + node.val;
        }
    public String serializeDFS(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeDFSh(root, res);
        res.setLength(res.length() - 1);
        return res.toString();
    }
        public void serializeDFSh(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("n,");
                return;
            }
            sb.append(node.val).append(",");
            serializeDFSh(node.left, sb);
            serializeDFSh(node.right, sb);
        }
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            if (cur == null) res.append("n,");
            else {
                res.append(cur.val).append(",");
                st.add(cur.right);
                st.add(cur.left);
            }
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] vals = data.split(",");
        int[] i = {0};
        return deserializehelper(vals, i);

    }
        public TreeNode deserializehelper(String[] vals, int[] i) {
            if (vals[i[0]].equals("n")) {
                i[0]++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
            i[0]++;
            node.left = deserializehelper(vals, i);
            node.right = deserializehelper(vals, i);
            return node;
        }
// BACKTRACK
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        combinationSumbacktrack(nums, target, res, tmp, 0);
        return res;
    }
        public void combinationSumbacktrack(int[] nums, int target, List<List<Integer>> res, List<Integer> tmp, int i) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            else if (target < 0 || i >= nums.length) return;
            else {
                tmp.add(nums[i]);
                combinationSumbacktrack(nums, target - nums[i], res, tmp, i);
                tmp.remove(tmp.get(tmp.size() - 1));
                combinationSumbacktrack(nums, target, res, tmp, i + 1);
            }
        }
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (word.isEmpty()) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j])
                    if (existdfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
        public boolean existdfs(char[][] board, String word, int i, int j, int x) {
            if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(x)) return false;
            if (x == word.length()) return true;

            char tmp = board[i][j];
            board[i][j] = '#';

            if (
                    existdfs(board, word, i + 1, j, x + 1) ||
                    existdfs(board, word, i, j + 1, x + 1) ||
                    existdfs(board, word, i - 1, j, x + 1) ||
                    existdfs(board, word, i, j - 1, x + 1)
            ) return true;

            board[i][j] = tmp;
            return false;
        }
// GRAPHS
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandshelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
        public void numIslandshelper(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
                return;
            grid[i][j] = '0';
            numIslandshelper(grid, i + 1, j);
            numIslandshelper(grid, i, j + 1);
            numIslandshelper(grid, i - 1, j);
            numIslandshelper(grid, i, j - 1);
        }
    public int numIslandsUF(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = 0;
        int[] rank = new int[ROWS * COLS];
        int[] parent = new int[ROWS * COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    int coord = r * COLS + c;
                    parent[coord] = coord;
                    rank[coord] = 0;
                    res++;
                }
            }
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    if (c + 1 < COLS && grid[r][c + 1] == '1') {
                        if (unionHeight(r * COLS + c, r * COLS + (c + 1), parent, rank)) res--;
                    }
                    if (r + 1 < ROWS && grid[r + 1][c] == '1') {
                        if (unionHeight(r * COLS + c, (r + 1) * COLS + c, parent, rank)) res--;
                    }
                }
            }
        }
        return res;
    }
        public boolean unionHeight(int node1, int node2, int[] parent, int[] rank) {
        int n1 = find(node1, parent);
        int n2 = find(node2, parent);
        if (n1 == n2) return false;
        if (rank[n1] > rank[n2]) {
            parent[n2] = n1;
        } else if (rank[n1] < rank[n2]) {
            parent[n1] = n2;
        } else {
            parent[n2] = n1;
            rank[n1]++;
        }
        return true;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> copies = new HashMap<>();
        return cloneGraphdfs(node, copies);
    }
        public Node cloneGraphdfs(Node node, Map<Node, Node> copies) {
            if (node == null) return null;
            if (copies.containsKey(node)) return copies.get(node);
            Node copy = new Node(node.val);
            copies.put(node, copy);
            for (Node n : node.neighbors) copy.neighbors.add(cloneGraphdfs(n, copies));
            return copy;
        }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> pacific = new HashSet<>();
        HashSet<Integer> atlantic = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            pacificAtlanticDFS(heights, pacific, i, 0, heights[i][0]);
            pacificAtlanticDFS(heights, atlantic, i, COLS - 1, heights[i][COLS - 1]);
        }
        for (int j = 0; j < COLS; j++) {
            pacificAtlanticDFS(heights, pacific, 0, j, heights[0][j]);
            pacificAtlanticDFS(heights, atlantic, ROWS - 1, j, heights[ROWS - 1][j]);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int coord = i * COLS + j;
                if (pacific.contains(coord) && atlantic.contains(coord))
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
        public void pacificAtlanticDFS(int[][] heights, Set<Integer> visited, int r, int c, int x) {
            if (r < 0 || r >= heights.length || c < 0 || c == heights[0].length || heights[r][c] < x) return;
            int coord = r * heights[0].length + c;
            if (visited.contains(coord)) return;
            visited.add(coord);
            pacificAtlanticDFS(heights, visited, r + 1, c, heights[r][c]);
            pacificAtlanticDFS(heights, visited, r - 1, c, heights[r][c]);
            pacificAtlanticDFS(heights, visited, r, c + 1, heights[r][c]);
            pacificAtlanticDFS(heights, visited, r, c - 1, heights[r][c]);
        }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> pre = new HashMap<>();
        HashSet<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            pre.put(i, new ArrayList<>());
        for (int[] pair : prerequisites)
            pre.get(pair[0]).add(pair[1]);
        for (int i = 0; i < numCourses; i++)
            if (!canFinishDFS(i, pre, visiting)) return false;
        return true;
    }
        public boolean canFinishDFS(int i, HashMap<Integer, List<Integer>> pre, HashSet<Integer> visiting) {
            if (pre.get(i).isEmpty()) return true;
            if (visiting.contains(i)) return false;
            visiting.add(i);
            for (int n : pre.get(i))
                if (!canFinishDFS(n, pre, visiting)) return false;
            visiting.remove(i);
            pre.put(i, new ArrayList<>());
            return true;
        }
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return edges.length == 0;
        if (edges.length == 0) return false;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int[] e : edges) {
            int node1 = e[0];
            int node2 = e[1];
            adj.putIfAbsent(node1, new ArrayList<>());
            adj.putIfAbsent(node2, new ArrayList<>());
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        if (!validTreeDFS(edges[0][0], -1, adj, visited)) return false;
        return visited.size() == n;

    }
        public boolean validTreeDFS(int i, int prev, HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited) {
            if (visited.contains(i)) return false;
            visited.add(i);
            for (int n : adj.get(i)) {
                if (prev == n) continue;
                if (!validTreeDFS(n, i, adj, visited)) return false;
            }
            return true;
        }
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;
        for (int[] e : edges) {
            int node1 = e[0];
            int node2 = e[1];
            adj.putIfAbsent(node1, new ArrayList<>());
            adj.putIfAbsent(node2, new ArrayList<>());
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res++;
                countComponentsDFS(i, -1, adj, visited);
            }
        }
        return res;
    }
        public void countComponentsDFS(int i, int prev, HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited) {
            visited.add(i);
            for (int n : adj.get(i))
                if (!visited.contains(n))
                    countComponentsDFS(n, i, adj, visited);
        }
    public int countComponentsUF(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int res = n;
        for (int i = 0; i < edges.length; i++) {
            if (unionSize(edges[i][0], edges[i][1], rank, parent)) res--;
        }
        return res;
    }
        public int find(int node, int[] parent) {
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        public boolean unionSize(int node1, int node2, int[] rank, int[] parent) {
            int n1 = find(node1, parent);
            int n2 = find(node2, parent);
            if (n1 == n2) return false;
            if (rank[n1] > rank[n2]) {
                parent[n2] = n1;
                rank[n1] += rank[n2];
            } else {
                parent[n1] = n2;
                rank[n2] += rank[n1];
            }
            return true;
        }
// INTERVALS
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (newInterval == null || cur[1] < newInterval[0]) {
                res.add(cur);
            } else if (cur[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(cur);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[prev][1]) intervals[prev][1] = Math.max(intervals[prev][1], intervals[i][1]);
            else {
                prev++;
                intervals[prev] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, prev + 1);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev) prev = intervals[i][1];
            else res++;
        }
        return res;
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);
            if (prev.end > intervals.get(i).start) return false;
        }
        return true;
    }
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        int len = intervals.size();
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        for (int i = 0; i < len; i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int res = 0;
        int count = 0;
        int start = 0;
        int end = 0;

        while (start < len) {
            if (startTime[start] < endTime[end]) {
                start++;
                count++;
            } else {
                end++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
// GREEDY
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;

        }
        return max;
    }
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= end) end = i;
        }
        return end == 0;
    }
    public boolean canJump2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }
// 1-D DYNAMIC PROGRAMMING
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairs2(int n) {
        int prelast = 1;
        int last = 1;
        for (int i = 0; i <= n - 2; i++) {
            int tmp = last + prelast;
            last = prelast;
            prelast = tmp;
        }
        return prelast;
    }
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        // [one, two, n, n+1, ...]
        for (int n : nums) {
            int tmp = Math.max(n + one, two);
            one = two;
            two = tmp;
        }
        return two;
    }
    public int robII(int[] nums) {
        int[] one = Arrays.copyOfRange(nums, 1, nums.length - 1);
        int[] two = Arrays.copyOfRange(nums, 0, nums.length - 2);
        return Math.max(nums[0], Math.max(rob(one), rob(two)));
    }
    public String longestPalindrome(String s) {
        String res = "";
        int l;
        int r;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            l = r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
    public int countSubstrings(String s) {
        int res = 0;
        int l;
        int r;
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int onedig = Integer.parseInt(s.substring(i - 1, i));
            int twodig = Integer.parseInt(s.substring(i - 2, i));
            if (onedig >= 1) dp[i] += dp[i - 1];
            if (twodig >= 10 && twodig <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int n : coins) {
                if (i - n >= 0)
                    dp[i] = Math.min(dp[i], 1+ dp[i - n]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public int maxProduct(int[] nums) {
       int max = nums[0];
       int min = nums[0];
       int res = nums[0];
       for (int i = 1; i < nums.length; i++) {
           if (nums[i] < 0) {
               int tmp = max;
               max = min;
               min = tmp;
           }
           max = Math.max(nums[i], max * nums[i]);
           min = Math.min(nums[i], min * nums[i]);
           res = Math.max(res, max);
       }
       return res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
// 2-D
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> dp = new HashMap<>();
        return uniquePathsDFS(m,n,dp);
    }
        public int uniquePathsDFS(int m, int n, HashMap<String, Integer> dp) {
        String coord = m + "," + n;
        if (dp.containsKey(coord)) return dp.get(coord);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        int res = uniquePathsDFS(m - 1, n, dp) + uniquePathsDFS(m, n- 1, dp);
        dp.put(coord, res);
        return res;
    }
    public int uniquePathsTAB(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = 0;
            }
        }
        dp[1][1] = 1;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (r + 1 < m) dp[r+1][c] += dp[r][c];
                if (c + 1 < n) dp[r][c+1] += dp[r][c];
            }
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length() + 1][text2.length() + 1];
    }







































}