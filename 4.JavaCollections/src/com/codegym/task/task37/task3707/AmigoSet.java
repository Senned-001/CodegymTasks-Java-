package com.codegym.task.task37.task3707;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class  AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT=new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet(){
        this.map=new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        int capacity = Math.max(16, (int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
        super.addAll(collection);           //method of parent, calling this.add forEach elem
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);       //method of parent using our iterator() and work with our map
    }

    @Override
    public boolean remove(Object o) {   //method of parent using our iterator() and work with our map 
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean add(E e) {

        return map.put(e,PRESENT)==null;
    }

    @Override
    public Object clone() {
        try {
            HashMap<E, Object> m = (HashMap<E, Object>) map.clone();

            AmigoSet<E> o = new AmigoSet<E>(m.keySet());
            return o;
        }catch (Exception e){
            throw new InternalError();
        }
    }
    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        int capacity=(int)in.readObject();
        float loadfactor=(float)in.readObject();
        this.map=new HashMap<>(capacity,loadfactor);
        int size=(int)in.readObject();
        for (int i = 0;i<size;i++){
            map.put((E)in.readObject(),PRESENT);
        }
    }
    private void writeObject(ObjectOutputStream out) throws Exception {
        out.defaultWriteObject();
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        out.writeObject(map.size());
        for(E x:map.keySet()) {
            out.writeObject(x);
        }
    }
}
