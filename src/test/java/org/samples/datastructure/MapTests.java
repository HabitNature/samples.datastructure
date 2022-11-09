package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.IMap;

public abstract class MapTests {

    protected abstract IMap<String, String> getMap();

    @Test
    public void isEmpty_noElement_returnTrue() {
        IMap<String, String> map = this.getMap();

        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void isEmpty_hasElement_returnFalse() {
        IMap<String, String> map = this.getMap();

        map.set("key", "value");

        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void length_noElement_returnZero() {
        IMap<String, String> map = this.getMap();

        Assert.assertEquals(0, map.size());
    }

    @Test
    public void length_hasElement_returnLength() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");
        map.set("key2", "value2");

        Assert.assertEquals(2, map.size());
    }

    @Test
    public void set_nullElement_successfully() {
        IMap<String, String> map = this.getMap();

        map.set("key1", null);
        String value = map.get("key1");

        Assert.assertEquals(1, map.size());
        Assert.assertEquals(null, value);
    }

    @Test
    public void set_notNullElement_successfully() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");
        String value = map.get("key1");

        Assert.assertEquals(1, map.size());
        Assert.assertEquals("value1", value);
    }

    @Test(expected = NullPointerException.class)
    public void set_nullKey_throwException() {
        IMap<String, String> map = this.getMap();

        map.set(null, "value1");
    }

    @Test
    public void set_multiElements_successfully() {
        IMap<String, String> map = this.getMap();

        final int count = 100;
        for (int i = 0; i < count; i++) {
            map.set("key" + i, "value" + i);
        }

        Assert.assertEquals(count, map.size());
    }

    @Test(expected = NullPointerException.class)
    public void get_nullKey_throwException() {
        IMap<String, String> map = this.getMap();

        map.get(null);
    }

    @Test
    public void get_noElement_returnNull() {
        IMap<String, String> map = this.getMap();

        String value = map.get("key");

        Assert.assertNull(value);
    }

    @Test
    public void get_hasElementKeyNotMatched_returnNull() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");
        String value = map.get("key2");

        Assert.assertNull(value);
    }

    @Test
    public void get_hasElementKeyMatched_returnValue() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");
        String value = map.get("key1");

        Assert.assertEquals("value1", value);
    }

    @Test
    public void containsKey_noKey_returnFalse() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");

        Assert.assertFalse(map.containsKey("no_key"));
    }

    @Test
    public void containsKey_hasKey_returnTrue() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");

        Assert.assertTrue(map.containsKey("key1"));
    }

    @Test(expected = NullPointerException.class)
    public void containsKey_nullKey_throwException() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");

        Assert.assertTrue(map.containsKey(null));
    }

    @Test
    public void containsValue_noValue_returnFalse() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");

        Assert.assertFalse(map.containsValue("no_value"));
    }

    @Test
    public void containsValue_hasValue_returnTrue() {
        IMap<String, String> map = this.getMap();

        map.set("key1", "value1");

        Assert.assertTrue(map.containsValue("value1"));
    }

    @Test
    public void remove_noElement_returnFalse(){
        IMap<String, String> map = this.getMap();

        Assert.assertFalse(map.remove("jskg"));
    }

    @Test
    public void remove_hasElementNotMatched_returnFalse(){
        IMap<String, String> map = this.getMap();

        map.set("key", "value");

        Assert.assertFalse(map.remove("jskg"));
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void remove_hasElementMatched_returnTrue(){
        IMap<String, String> map = this.getMap();

        map.set("key", "value");

        Assert.assertTrue(map.remove("key"));
        Assert.assertEquals(0, map.size());
    }

}
