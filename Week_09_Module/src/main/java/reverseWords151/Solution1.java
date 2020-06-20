package reverseWords151;

public class Solution1 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" +");

        for (int i = 0; i < arr.length / 2; i++) {
            String tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        StringBuilder builder = new StringBuilder();
        for (String value : arr) {
            builder.append(value).append(" ");
        }

        return builder.toString().trim();
    }
}
