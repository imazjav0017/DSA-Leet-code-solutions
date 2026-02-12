import java.util.*;

class Solution
 {
    public int minAreaRect(int[][] points) 
    {
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points)
         {
            pointSet.add(p[0] + "," + p[1]);
        }

        int n = points.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
         {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++)
             {
                int x2 = points[j][0];
                int y2 = points[j][1];

                // They must form diagonal of rectangle
                if (x1 != x2 && y1 != y2) {
                    String point1 = x1 + "," + y2;
                    String point2 = x2 + "," + y1;

                    if (pointSet.contains(point1) && pointSet.contains(point2)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        if (area < min)
                         {
                            min = area;
                        }
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}