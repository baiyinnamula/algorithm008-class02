package combine77;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrace(1, new LinkedList<Integer>());
        return output;
    }

    private void backtrace(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
        }

        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrace(i + 1, curr);
            curr.removeLast();
        }
    }
}
