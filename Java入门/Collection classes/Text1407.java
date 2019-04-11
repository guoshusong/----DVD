package azs;


import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

public class Text1407 {
    public static void main(String [] args){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("A");
        set.add("a");
        set.add("c");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("A");
        list.add("a");
        list.add("c");
        System.out.println(set);
        System.out.println(list);
    }
}
/*
* Set集合不能有重复的元素
* List集合可以有重复的元素
* */