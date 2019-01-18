import java.util.TreeMap;

/**
 * <a href = "https://leetcode.com/problems/boats-to-save-people/">Problem here.</a>
 * There is better solution with two pointers, but this works too.
 * Created by NubbY
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> peopleMapped = new TreeMap<>();
        for (int man : people) peopleMapped.put(man, peopleMapped.getOrDefault(man, 0) + 1);

        int totalBoatsNeeded = 0;
        while (peopleMapped.size() > 0) {
            int firstMan = peopleMapped.lastKey();
            int amountOfFirstMan = peopleMapped.get(firstMan);
            peopleMapped.put(firstMan, amountOfFirstMan - 1);
            if (amountOfFirstMan == 1) peopleMapped.remove(firstMan);
            int maxWeightPossibleToAdd = limit - firstMan;

            if (peopleMapped.floorEntry(maxWeightPossibleToAdd) != null) {
                int secondMan = peopleMapped.floorEntry(maxWeightPossibleToAdd).getKey();
                int amountOfSecondMan = peopleMapped.get(secondMan);
                peopleMapped.put(secondMan, amountOfSecondMan - 1);
                if (amountOfSecondMan == 1) peopleMapped.remove(secondMan);
            }

            totalBoatsNeeded++;
        }
        return totalBoatsNeeded;
    }
}
