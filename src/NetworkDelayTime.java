import java.util.PriorityQueue;

/**
 * <a href = "https://leetcode.com/problems/network-delay-time/">Problem here.</a>
 * D'ikstra's algorithm decision
 * Created by NubbY
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] testEdges = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int K = 2;
        NetworkDelayTime test = new NetworkDelayTime();
        System.out.println(test.networkDelayTime(testEdges, N, K));

    }

    public int networkDelayTime(int[][] times, int N, int K) {

        int[] timeTo = new int[N + 1];
        for (int i = 0; i < timeTo.length; i++) timeTo[i] = Integer.MAX_VALUE;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));
        timeTo[K] = 0;

        while (!pq.isEmpty()) {
            Edge v = pq.poll();
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == v.target) {
                    //relaxing edge
                    if (timeTo[times[i][1]] > timeTo[v.target] + times[i][2]) {
                        timeTo[times[i][1]] = timeTo[v.target] + times[i][2];
                        Edge w = new Edge(times[i][1], timeTo[times[i][1]]);
                        pq.remove(w);
                        pq.add(w);
                    }
                }
            }
        }

        int currentMaxTime = 0;
        for (int i = 1; i <= N; i++) {
            currentMaxTime = Math.max(timeTo[i], currentMaxTime);
        }

        if (currentMaxTime == Integer.MAX_VALUE) return -1;
        else return currentMaxTime;
    }

    /**
     * By implementing Comparable, equals(and hashcode), we get PriorityQueue with indices (indices = target)
     * so we can retrieve elements just by their unique target index, not counting time.
     */
    private class Edge implements Comparable {
        int target;
        int time;

        public Edge(int target, int time) {
            this.target = target;
            this.time = time;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Edge)) return false;
            return this.target == ((Edge) obj).target;
        }

        @Override
        public int hashCode() {
            return target;
        }

        @Override
        public String toString() {
            return "Target  = " + target + "; Time = " + time;
        }

        @Override
        public int compareTo(Object o) {
            return -Integer.compare(this.target, ((Edge) o).target);
        }
    }
}
