package custom;

/**
 * Created by NubbY
 */
public class RLECompression {
    public static void main(String[] args) {
        RLECompression test = new RLECompression();
        String input = "aaaabbbbbbbbbcbbbbbcbbbbbbbbbbbaa";
        System.out.println(test.rleCompress(input));
    }

    private String rleCompress(String input) {
        StringBuilder builder = new StringBuilder();

        if (input.length() == 0) return "";

        char prev = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (prev != input.charAt(i)) {
                builder.append(prev).append(count);
                count = 1;
                prev = input.charAt(i);
            } else {
                count++;
            }
        }
        builder.append(prev).append(count);
        return builder.toString();
    }
}
