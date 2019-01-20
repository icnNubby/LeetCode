import java.util.ArrayList;

/**
 * <a href = "https://leetcode.com/problems/word-search/">Problem here.</a>
 * Created by NubbY
 */
public class WordSearch {

    private char[][] board;

    public static void main(String[] args) {
        char[][] testBoard =
                {{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        WordSearch test = new WordSearch();

        String testWord = "ABCCED";
        System.out.println(test.exist(testBoard, testWord));

        testWord = "ADEESCFSABCED";
        System.out.println(test.exist(testBoard, testWord));

        testWord = "ABCB";
        System.out.println(test.exist(testBoard, testWord));

    }

    public boolean exist(char[][] board, String word) {
        this.board = board;


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (word.length() == 1) return true;
                    Route routeFirst = new Route(i, j, 1);
                    ArrayList<ArrayList<Route>> que = new ArrayList<>();
                    ArrayList<Route> ll = new ArrayList<>();
                    ll.add(routeFirst);
                    que.add(ll);
                    do {

                        ArrayList<Route> current = que.get(que.size() - 1);
                        que.remove(que.size() - 1);

                        Route currentRoute = current.get(current.size() - 1);
                        int x = currentRoute.x;
                        int y = currentRoute.y;
                        int currentLen = currentRoute.currentLen;

                        Route[] routes = new Route[4];
                        routes[0] = new Route(x, y - 1, currentLen + 1);
                        routes[1] = new Route(x - 1, y, currentLen + 1);
                        routes[2] = new Route(x + 1, y, currentLen + 1);
                        routes[3] = new Route(x, y + 1, currentLen + 1);

                        for (int k = 0; k < 4; k++) {
                            if (routes[k].isValid(word) && !current.contains(routes[k])) {
                                ArrayList<Route> newPossibleWay = new ArrayList<>(current);
                                newPossibleWay.add(routes[k]);
                                que.add(newPossibleWay);
                                if (routes[k].currentLen == word.length()) return true;
                            }
                        }

                    } while (que.size() > 0);
                }
            }
        }
        return false;
    }

    private class Route {
        int x;
        int y;
        int currentLen;

        Route(int x, int y, int currentLen) {
            this.x = x;
            this.y = y;
            this.currentLen = currentLen;
        }

        boolean isValid(String checkFor) {
            int xGridMax = board.length;
            int yGridMax = board[0].length;
            return ((x >= 0 && x < xGridMax) &&
                    (y >= 0 && y < yGridMax) &&
                    board[x][y] == checkFor.charAt(currentLen - 1));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Route)) return false;
            return ((((Route) obj).x == this.x) && ((Route) obj).y == this.y);
        }
    }
}
