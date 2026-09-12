class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] diff = new int[n];

        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];

            diff[start - 1] += seats;

            if (end < n) {
                diff[end] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}