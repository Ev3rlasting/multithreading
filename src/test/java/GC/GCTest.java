package GC;

import TestEntities.TestObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

// Change JVM option -Xmx -Xms
public class GCTest {

    @Test
    public void testWeakHashMap() throws InterruptedException {
        WeakHashMap<String, TestObject> map = new WeakHashMap<>();
        TestObject obj = new TestObject();
        List<TestObject> list = new ArrayList();
        obj.setName("Rishi");
        String test = "test";
        map.put(test, obj);
        obj.setName("Ray"
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString()
                + UUID.randomUUID().toString());
        int i = 0;
        while (i++ < 100000) {
            //            TestObject objTemp = new TestObject();
            //            objTemp.setName("a");
            map.put(UUID.randomUUID().toString(), obj);
            //            list.add(objTemp);
        }
        test = null;
        obj = null;
        System.gc();
        Thread.sleep(2000);
        Assert.assertEquals(1, map.size());
    }
}
