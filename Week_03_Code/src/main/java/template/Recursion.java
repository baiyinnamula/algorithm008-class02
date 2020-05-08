package template;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yangbaiyinnamula
 * 递归代码模板
 */
public class Recursion {
    private static final int MAX_LEVEL = 100;

    public void recursion(int level, int param) {
        //terminator
        if (level > MAX_LEVEL) {
            //process result
            return;
        }
        //process current logic
        int newParam = process(level, param);

        //drill down
        recursion(level + 1, newParam);

        //restore current status
    }

    private int process(int level, int param) {

        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
