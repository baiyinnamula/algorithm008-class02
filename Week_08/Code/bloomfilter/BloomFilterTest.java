package bloomfilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BloomFilterTest {
    @Test
    public void test(){
        BloomFilter filter = new BloomFilter(1000);
        Random random = new Random();
        filter.add(1000);
        filter.add(2000);
        filter.add(3000);
        filter.add(2210);
        filter.add(2323);
        filter.add(4400);
        Assertions.assertFalse(filter.contains(2323));
    }
}
