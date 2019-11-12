package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* 
Build a tree (part 1)

*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String>root;
    LinkedList<Entry>tree=new LinkedList<>();


    public CustomTree() {
        this.root=new Entry<String>("elementName");
        tree.add(root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.tree.size()-1;
    }


    public boolean add(String s){
        /*if((tree.size()==3)&&(!tree.get(1).isAvailableToAddChildren()&&(!tree.get(2).isAvailableToAddChildren()))){
            tree.get(1).availableToAddLeftChildren=true;
            tree.get(1).availableToAddRightChildren=true;
            tree.get(2).availableToAddLeftChildren=true;
            tree.get(2).availableToAddRightChildren=true;
        }
*/      boolean avalibleToDe=false;


        for(int i=0;i<tree.size();i++){
            if(tree.get(i).isAvailableToAddChildren()){
                avalibleToDe=true;
                if(tree.get(i).availableToAddLeftChildren) {
                    tree.get(i).availableToAddLeftChildren=false;
                    Entry node=new Entry(s);
                    node.parent=tree.get(i);
                    tree.get(i).leftChild=node;
                    tree.add(node);
                    break;
                }else {
                    tree.get(i).availableToAddRightChildren=false;
                    Entry node=new Entry(s);
                    node.parent=tree.get(i);
                    tree.get(i).rightChild=node;
                    tree.add(node);
                    break;
                }
            }
        }
        if(!avalibleToDe){
            for(int i=0;i<tree.size();i++){
                if(tree.get(i).leftChild==null&&tree.get(i).rightChild==null) {
                   // tree.get(i).availableToAddLeftChildren = true;


                    tree.get(i).availableToAddRightChildren = true;
                    Entry node=new Entry(s);
                    tree.get(i).leftChild=node;
                    node.parent=tree.get(i);
                    tree.add(node);
                    break;
                }
            }
            //this.add(s);
        }

        return true;
    }

    public String getParent(String s){
        for(int i=0;i<tree.size();i++){
            if(tree.get(i).elementName.equals(s)) return tree.get(i).parent.elementName;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        String s=null;
        try {
            s=(String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        for(int i=0;i<tree.size();i++) {
            if (tree.get(i).elementName.equals(s)){
               /* if(tree.get(i).parent.leftChild.equals(tree.get(i))){
                    tree.get(i).parent.availableToAddLeftChildren=true;
                    tree.get(i).parent.leftChild=null;
                }else{
                    tree.get(i).parent.availableToAddRightChildren=true;
                    tree.get(i).parent.rightChild=null;
                }*/
                Entry NodeforDel1=null;
                Entry NodeforDel2=null;
                if(tree.get(i).leftChild!=null) {
                    NodeforDel1=tree.get(i).leftChild;
                }
                if(tree.get(i).rightChild!=null){
                    NodeforDel2=tree.get(i).rightChild;
                }
                tree.remove(i);
                if(NodeforDel1!=null) this.remove(NodeforDel1.elementName);
                if(NodeforDel2!=null) this.remove(NodeforDel2.elementName);
                return true;
            }
        }
        return false;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren=true;
            this.availableToAddRightChildren=true;
        }

        public boolean isAvailableToAddChildren(){
            return this.availableToAddLeftChildren||this.availableToAddRightChildren;
        }

    }

}
