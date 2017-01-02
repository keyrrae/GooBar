package adhoc;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
The black pixels are connected, i.e., there is only one black region.
Pixels are connected horizontally and vertically.
Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
 */
public class SmallestRectangleEnclosingBlackPixels {
    private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        helper(image, x, y);
        System.out.printf("%d %d %d %d", minX, minY, maxX, maxY);
        return(maxX - minX + 1) * (maxY - minY + 1);
    }

    private void helper(char[][] image, int x, int y){
        int m = image.length, n = image[0].length;

        if(x < 0 || x >= m || y <0|| y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        helper(image, x+1, y);
        helper(image, x-1, y);
        helper(image, x, y+1);
        helper(image, x, y-1);
    }
}
