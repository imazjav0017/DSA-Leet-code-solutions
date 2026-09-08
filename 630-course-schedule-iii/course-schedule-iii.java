class Solution {
    public int scheduleCourse(int[][] courses) {

        // Earliest deadline first
        Arrays.sort(courses, (a,b) ->
            Integer.compare(a[1], b[1])
        );

        // Selected course durations
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int totalTime = 0;

        for (int[] course : courses) {

            int duration = course[0];
            int deadline = course[1];

            // Temporarily take course
            totalTime += duration;
            pq.offer(duration);

            // Schedule impossible
            if (totalTime > deadline) {

                // Sacrifice longest course
                totalTime -= pq.poll();
            }
        }

        return pq.size();
    }
}