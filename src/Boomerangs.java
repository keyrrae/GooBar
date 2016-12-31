import com.oracle.webservices.internal.api.message.BasePropertySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanwang on 11/5/16.
 */
public class Boomerangs {
    public static void main(String[] args){
        int[][] points = {{0,0}, {1,0}, {2,0}};
        int cnt = numberOfBoomerangs(points);
        return;
    }
    public static int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0) return 0;
        if(points[0] == null || points[0].length == 0) return 0;
        Map<Long, List<Pair>> map = new HashMap<>();
        int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j< n; j++){
                int diffx = points[i][0] - points[j][0];
                int diffy = points[i][1] - points[j][1];
                long dist = diffx * diffx + diffy * diffy;
                map.putIfAbsent(dist, new ArrayList<Pair>());
                map.get(dist).add(new Pair(points[i][0], points[i][1], points[j][0], points[j][1]));
            }
        }
        int count = 0;

        for(List<Pair> lst: map.values()){
            for(int i = 0; i < lst.size(); i++){
                for(int j = i + 1; j < lst.size(); j++){
                    if(lst.get(i).hasCommonPoint(lst.get(j))){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static class Pair{
        int[] a, b;
        public Pair(int x1, int y1, int x2, int y2){
            a = new int[2];
            b = new int[2];
            a[0] = x1;
            a[1] = y1;
            b[0] = x2;
            b[1] = y2;
        }

        public boolean hasCommonPoint(Pair that){
            boolean aa = this.a[0] == that.a[0] && this.a[1] == that.a[1];
            boolean ab = this.a[0] == that.b[0] && this.a[1] == that.b[1];
            boolean ba = this.b[0] == that.a[0] && this.b[1] == that.a[1];
            boolean bb = this.b[0] == that.b[0] && this.b[1] == that.b[1];
            return aa || bb || ab || ba;
        }
    }
}
