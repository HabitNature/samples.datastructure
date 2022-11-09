package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.ISet;

public abstract class SetTests {
    protected abstract ISet<String> getSet();

    @Test
    public void isEmpty_noElement_returnTrue() {
        ISet<String> set = this.getSet();

        Assert.assertTrue(set.isEmpty());
    }

    @Test
    public void isEmpty_hasElement_returnFalse() {
        ISet<String> set = this.getSet();

        set.add("value1");

        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void size_noElement_returnZero() {
        ISet<String> set = this.getSet();

        Assert.assertEquals(0, set.size());
    }

    @Test
    public void size_hasElement_returnSize() {
        ISet<String> set = this.getSet();

        set.add("value1");

        Assert.assertEquals(1, set.size());
    }

    @Test
    public void add_oneElement_successfully(){
        ISet<String> set = this.getSet();

        boolean added = set.add("value1");

        Assert.assertEquals(1, set.size());
        Assert.assertTrue(added);
    }

    @Test
    public void add_multiElement_successfully(){
        ISet<String> set = this.getSet();

        final int count = 100;
        for(int i = 0; i< count; i++){
            set.add("value" + i);
        }

        Assert.assertEquals(count, set.size());
    }

    @Test
    public void add_sameElement_successfully(){
        ISet<String> set = this.getSet();

        final int count = 100;
        boolean added = false;
        for(int i = 0; i< count; i++){
            added  = set.add("value");
        }

        Assert.assertEquals(1, set.size());
        Assert.assertFalse(added);
    }

    @Test
    public void contains_noElement_returnFalse(){
        ISet<String> set = this.getSet();

        Assert.assertFalse(set.contains("abc"));
    }

    @Test
    public void contains_hasElementNotMatched_returnFalse(){
        ISet<String> set = this.getSet();

        set.add("abc");

        Assert.assertFalse(set.contains("abcdef"));
    }

    @Test
    public void contains_hasElementMatched_returnTrue(){
        ISet<String> set = this.getSet();

        set.add("abc");

        Assert.assertTrue(set.contains("abc"));
    }

    @Test
    public void remove_notContainsElement_returnFalse(){
        ISet<String> set = this.getSet();

        set.add("abc");

        boolean removed = set.remove("abcdef");

        Assert.assertFalse(removed);
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void remove_containsElement_returnTrue(){
        ISet<String> set = this.getSet();

        set.add("abc");

        boolean removed = set.remove("abc");

        Assert.assertTrue(removed);
        Assert.assertEquals(0, set.size());
    }
}
