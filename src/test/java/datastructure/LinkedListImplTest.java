package datastructure;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLinkedList() {
        LinkedListImpl list = new LinkedListImpl();
        list.add("0");
        list.add("1");
        list.add("2");

        Assert.assertEquals("0", list.get(0));
        Assert.assertEquals("1", list.get(1));
        Assert.assertEquals("2", list.get(2));

        list.remove(0);
        Assert.assertEquals("1", list.get(0));
        Assert.assertEquals("2", list.get(1));

        list.add("3");
        Assert.assertEquals("1", list.get(0));
        Assert.assertEquals("2", list.get(1));
        Assert.assertEquals("3", list.get(2));

        list.remove(1);
        Assert.assertEquals("1", list.get(0));
        Assert.assertEquals("3", list.get(1));

        list.remove(1);
        Assert.assertEquals("1", list.get(0));

        list.remove(1);
    }
}