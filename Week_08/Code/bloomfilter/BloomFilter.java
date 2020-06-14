package bloomfilter;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;

/**
 * 布隆过滤器实现
 */
public class BloomFilter {
    /**
     * boolean hash 表
     */
    private BitSet hashes;
    /**
     * 随机数生成器
     */
    private RandomInRange randomInRange;
    /**
     * hash 函数数量
     */
    private int k;
    /**
     * ln(2)
     */
    private static final double LN2 = 0.6931471805599453; // ln(2)

    /**
     * @param n 计划存储元素数量
     * @param m boolean 容器大小
     */
    public BloomFilter(int n, int m) {
        // 哈希函数数量 = LN2 * ( 容器大小 / 计划存储元素数量)
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) {
            k = 1;
        }
        this.hashes = new BitSet(m);
        this.randomInRange = new RandomInRange(m, k);
    }

    /**
     * @param n 计划存储元素数量
     *          boolean 容器大小为 1024 * 1024 * 8
     */
    public BloomFilter(int n) {
        this(n, 1024 * 1024 * 8);
    }

    /**
     * 容器中添加元素
     *
     * @param o Object
     */
    public void add(Object o) {
        randomInRange.init(o);
        for (RandomInRange r : randomInRange) {
            hashes.set(r.value);
        }
    }

    /**
     * If the element is in the container, returns true.
     * If the element is not in the container, returns true with a probability ≈ e^(-ln(2)² * m/n), otherwise false.
     * So, when m is large enough, the return value can be interpreted as:
     * - true  : the element is probably in the container
     * - false : the element is definitely not in the container
     *
     * @param o 检查的元素
     * @return 返回结果
     */
    public boolean contains(Object o) {
        randomInRange.init(o);
        for (RandomInRange r : randomInRange) {
            if (!hashes.get(r.value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从过滤器删除所有元素
     */
    public void clear() {
        hashes.clear();
    }

    /**
     * 创建当前过滤器副本
     *
     * @return BloomFilter
     */
    @Override
    public BloomFilter clone() throws CloneNotSupportedException {
        return (BloomFilter) super.clone();
    }

    /**
     * 生成过滤器唯一 hash
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return hashes.hashCode() ^ k;
    }

    /**
     * 判断两个过滤器是否相等
     *
     * Test if the filters have equal bitsets.
     * WARNING: two filters may contain the same elements, but not be equal
     * (if the filters have different size for example).
     *
     * @param other BloomFilter
     * @return bool
     */
    public boolean equals(BloomFilter other) {
        return this.hashes.equals(other.hashes) && this.k == other.k;
    }

    /**
     * 合并两个布隆过滤器
     * Merge another bloom filter into the current one.
     * After this operation, the current bloom filter contains all elements in
     * other.
     *
     * @param other BloomFilter
     */
    public void merge(BloomFilter other) {
        if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.hashes.or(other.hashes);
    }

    /**
     *
     */
    private static class RandomInRange implements Iterable<RandomInRange>, Iterator<RandomInRange> {
        private Random random;
        // 随机元素最大值
        private int max;
        // 需要生成的随机元素数量
        private int count;
        // 已生成随机元素数量
        private int i = 0;
        // 当前值
        int value;

        /**
         *
         * @param max 随机元素最大值
         * @param count 需要生成的随机元素数量
         */
        RandomInRange(int max, int count) {
            this.max = max;
            this.count = count;
            random = new Random();
        }

        void init(Object o) {
            random.setSeed(o.hashCode());
        }

        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = random.nextInt() % max;
            if (value < 0) {
                value = -value;
            }
            return this;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
