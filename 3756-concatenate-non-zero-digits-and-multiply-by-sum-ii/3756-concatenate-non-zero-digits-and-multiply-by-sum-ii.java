class Solution {
     static final int MOD = 1_000_000_007;

    static class Node {
        long val;
        int len;

        Node() {}

        Node(long v, int l) {
            val = v;
            len = l;
        }
    }

    Node[] tree;
    long[] pow10;
    int[] digits;
    public int[] sumAndMultiply(String s, int[][] queries) {
         int n = s.length();

        // Prefix sum of non-zero digits
        int[] prefix = new int[n + 1];

        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefix[i + 1] = prefix[i];

            if (d != 0) {
                prefix[i + 1] += d;
                posList.add(i);
                digitList.add(d);
            }
        }

        int m = digitList.size();

        digits = new int[m];

        for (int i = 0; i < m; i++)
            digits[i] = digitList.get(i);

        pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 1; i <= m; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        tree = new Node[Math.max(1, 4 * Math.max(1, m))];

        if (m > 0)
            build(1, 0, m - 1);

        int[] positions = posList.stream().mapToInt(Integer::intValue).toArray();

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefix[r + 1] - prefix[l];

            if (sum == 0) {
                ans[i] = 0;
                continue;
            }

            int left = lowerBound(positions, l);
            int right = upperBound(positions, r) - 1;

            Node res = query(1, 0, m - 1, left, right);

            ans[i] = (int) ((res.val * sum) % MOD);
        }

        return ans;
    }

    void build(int idx, int l, int r) {

        if (l == r) {
            tree[idx] = new Node(digits[l], 1);
            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        long value = (a.val * pow10[b.len] + b.val) % MOD;

        return new Node(value, a.len + b.len);
    }

    Node query(int idx, int l, int r, int ql, int qr) {

        if (ql > r || qr < l)
            return null;

        if (ql <= l && r <= qr)
            return tree[idx];

        int mid = (l + r) / 2;

        return merge(
                query(idx * 2, l, mid, ql, qr),
                query(idx * 2 + 1, mid + 1, r, ql, qr)
        );
    }

    int lowerBound(int[] arr, int target) {

        int l = 0, r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    int upperBound(int[] arr, int target) {

        int l = 0, r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
        
    }
