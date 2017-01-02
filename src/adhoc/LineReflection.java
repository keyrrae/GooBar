package adhoc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
        for(int i = 0; i <points.length; i++){
            minx = Math.min(points[i][0], minx);
            maxx = Math.max(points[i][0], maxx);
            Set<Integer> set = map.getOrDefault(points[i][0], new HashSet<Integer>());
            set.add(points[i][1]);
            map.put(points[i][0], set);
        }

        int twoTimesX = minx + maxx;

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int otherx = twoTimesX - x;
            if(!map.containsKey(otherx) || !map.get(otherx).contains(y)) return false;
        }
        return true;
    }

}
