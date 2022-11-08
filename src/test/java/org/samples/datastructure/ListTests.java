package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.IList;

public abstract class ListTests {
    protected abstract IList<Long> getList();

    @Test
    public void isEmpty_noOperate_returnTrue() {
        IList<Long> list = this.getList();

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_add_returnFalse() {
        IList<Long> list = this.getList();

        list.add(3L);

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty_removeLast_returnTrue() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.remove(0);

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void add_byObject_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(5L, (long) list.get(2));
    }

    @Test
    public void add_zeroIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        list.add(0, 6L);

        Assert.assertEquals(4, list.size());
        Assert.assertEquals(6L, (long) list.get(0));
    }

    @Test
    public void add_lengthIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        list.add(3, 6L);

        Assert.assertEquals(4, list.size());
        Assert.assertEquals(6L, (long) list.get(3));
    }

    @Test
    public void add_anyIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        list.add(1, 6L);

        Assert.assertEquals(4, list.size());
        Assert.assertEquals(6L, (long) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_negativeIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        list.add(-1, 6L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_overMaxIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        list.add(4, 6L);
    }

    @Test
    public void remove_byExistObject_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        boolean removed = list.remove(4L);

        Assert.assertTrue(removed);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(3L, (long) list.get(0));
        Assert.assertEquals(5L, (long) list.get(1));
    }

    @Test
    public void remove_byNotExistObject_Failed() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        boolean removed = list.remove(8L);

        Assert.assertFalse(removed);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void remove_zeroIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.remove(0);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(3L, (long) old);
    }

    @Test
    public void remove_anyIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.remove(1);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(4L, (long) old);
    }

    @Test
    public void remove_lastIndex_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.remove(2);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(5L, (long) old);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_negativeIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_overMaxIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.remove(3);
    }

    @Test
    public void set_firstOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.set(0, 7L);

        Assert.assertEquals(3L, (long) old);
        Assert.assertEquals(7L, (long) list.get(0));
    }

    @Test
    public void set_lastOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.set(2, 8L);

        Assert.assertEquals(5L, (long) old);
        Assert.assertEquals(8L, (long) list.get(2));
    }

    @Test
    public void set_anyOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);
        Long old = list.set(1, 9L);

        Assert.assertEquals(4L, (long) old);
        Assert.assertEquals(9L, (long) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set_negativeIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long old = list.set(-1, 9L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set_overMaxIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);
        Long old = list.set(3, 9L);

    }

    @Test
    public void get_firstOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);
        Long value = list.get(0);

        Assert.assertEquals(3L, (long) value);
    }

    @Test
    public void get_anyOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);
        Long value = list.get(1);

        Assert.assertEquals(4L, (long) value);
    }

    @Test
    public void get_lastOne_successfully() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);
        Long value = list.get(2);

        Assert.assertEquals(5L, (long) value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_negativeIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long value = list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_overMaxIndex_throwException() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        Long value = list.get(3);
    }

    @Test
    public void contains_notExistsElement_returnFalse() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        boolean contains = list.contains(7L);
        Assert.assertFalse(contains);
    }

    @Test
    public void contains_existsElement_returnTrue() {
        IList<Long> list = this.getList();

        list.add(3L);
        list.add(4L);
        list.add(5L);

        boolean contains = list.contains(4L);
        Assert.assertTrue(contains);
    }
}
