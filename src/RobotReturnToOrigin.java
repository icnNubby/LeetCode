/**
 * <a href = "https://leetcode.com/problems/robot-return-to-origin">Problem here.</a>
 * Created by NubbY
 */
public class RobotReturnToOrigin {
    public static void main(String[] args) {
        RobotReturnToOrigin test = new RobotReturnToOrigin();
        System.out.println(test.judgeCircle("LLRRUUDDLR"));
    }

    public boolean judgeCircle(String moves) {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R': {
                    countX++;
                    break;
                }
                case 'L': {
                    countX--;
                    break;
                }
                case 'U': {
                    countY++;
                    break;
                }
                case 'D': {
                    countY--;
                    break;
                }
            }
        }
        return ((countX == 0) && (countY == 0));
    }
}
