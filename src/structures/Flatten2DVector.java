package structures;

import java.util.Iterator;
import java.util.List;

/**
 * Created by xuanwang on 1/1/17.
 */
public class Flatten2DVector implements Iterator<Integer> {

        private int listIdx;
        private int eleIdx;
        private List<List<Integer>> vec;

        public Flatten2DVector(List<List<Integer>> vec2d) {
            this.listIdx = 0;
            this.eleIdx = 0;
            this.vec = vec2d;
        }

        @Override
        public Integer next() {
            int ret = vec.get(listIdx).get(eleIdx);
            eleIdx++;
            return ret;
        }

        @Override
        public boolean hasNext() {
            while(listIdx<vec.size()){
                if(eleIdx < vec.get(listIdx).size()){
                    return true;
                }else{
                    listIdx++;
                    eleIdx = 0;
                }
            }
            return false;
        }
}
