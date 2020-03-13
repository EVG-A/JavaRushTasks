package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        float size = Math.max(16, collection.size() / .75f + 1);
        this.map = new HashMap<>((int)size);
        for (E e: collection){
            map.put(e, PRESENT);
        }
    }

    @Override
    public boolean add(Object o) {
        return null==map.put((E) o,PRESENT);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
