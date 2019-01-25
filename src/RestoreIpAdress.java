import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//TODO trailing zero problems

/**
 * <a href = "https://leetcode.com/problems/restore-ip-addresses/"></a>
 * Created by NubbY
 */
public class RestoreIpAdress {

    public static void main(String[] args) {
        RestoreIpAdress test = new RestoreIpAdress();
        List<String> testOut = test.restoreIpAddresses("25525511135");
        for (String str : testOut) System.out.println(str);
    }

    private boolean checkSingleIfValid(String s) {
        return (Integer.valueOf(s) <= 255);
    }

    private String checkIfValid(String s, int l1, int l2, int l3) {
        String s1 = s.substring(0, l1);
        String s2 = s.substring(l1, l1 + l2);
        String s3 = s.substring(l1 + l2, l1 + l2 + l3);
        String s4 = s.substring(l1 + l2 + l3);
        String out = "";
        if (checkSingleIfValid(s1) && checkSingleIfValid(s2) && checkSingleIfValid(s3) && checkSingleIfValid(s4)) {
            out = Integer.valueOf(s1) + "." + Integer.valueOf(s2) + "." + Integer.valueOf(s3) + "." + Integer.valueOf(s4);
        }
        return out;
    }

    public List<String> restoreIpAddresses(String s) {
        Set<String> ipAdresses = new HashSet<>();
        List<String> ipAdressesList = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return null;
        int[] lens = new int[4];

        for (int i1 = 1; i1 <= 3; i1++)
            for (int i2 = 1; i2 <= 3; i2++)
                for (int i3 = 1; i3 <= 3; i3++)
                    for (int i4 = 1; i4 <= 3; i4++) {
                        if (i1 + i2 + i3 + i4 == s.length()) {
                            String check = (checkIfValid(s, i1, i2, i3));
                            if (!check.equals("")) ipAdresses.add(check);
                        }
                    }
        ipAdressesList.addAll(ipAdresses);
        return ipAdressesList;
    }
}
