package org.suai.lab4;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;

public class SortedIntegerList {
    private final boolean repeat;
    private final List<Integer> list;

    public SortedIntegerList(boolean repeat) {
        this.repeat = repeat;
        this.list = new LinkedList<Integer>();
    }

    public SortedIntegerList(SortedIntegerList sr) {
        this.repeat = sr.repeat;
        this.list = new ArrayList<Integer>();
        for (int cur : sr.list)
            this.add(cur);
    }

    public void add(int val) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int cur = it.next();
            if (cur > val) {
                it.set(val);
                it.add(cur);
                return;
            }
            if (cur == val) {
                if (repeat) {
                    it.add(val);
                }
                return;
            }
        }
        list.add(val);
    }

    public SortedIntegerList oldRemove(SortedIntegerList sr){
        if (sr.repeat != this.repeat)
            throw new RuntimeException("в методе remove списки разных типов");
        SortedIntegerList res = new SortedIntegerList(this);
        for (int cur : sr.list)
            res.remove(cur);
        return res;
    }

    public SortedIntegerList Tremove(SortedIntegerList sr) {
        if (sr.repeat != this.repeat)
            throw new RuntimeException("в методе remove списки разных типов");
        SortedIntegerList res = new SortedIntegerList(this);
        ListIterator<Integer> it1 = res.list.listIterator();
        ListIterator<Integer> it2 = sr.list.listIterator();

        int cur1 = 0;
        int cur2 = 0;
        boolean cursWasNotEquals = false;

        while (it2.hasNext() && it1.hasNext()){
            if (cur1 < cur2){
                cur1 = it1.next();
                cursWasNotEquals = true;
                continue;
            }
            if (cur1 > cur2){
                cur2 = it2.next();
                cursWasNotEquals = true;
                continue;
            }
            if (!cursWasNotEquals) {
                cur1 = it1.next();
                cur2 = it2.next();
            }
            cursWasNotEquals = false;
            if (cur1 == cur2)
                it1.remove();
        }

        return res;
    }

    public void remove(int val) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int cur = it.next();
            if (cur == val) {
                it.remove();
                return;
            }
        }
    }

    public SortedIntegerList remove(SortedIntegerList sr) {
        if (sr.repeat != this.repeat)
            throw new RuntimeException("в методе remove списки разных типов");
        SortedIntegerList res = new SortedIntegerList(this.repeat);
        ListIterator<Integer> it1 = this.list.listIterator();
        ListIterator<Integer> it2 = sr.list.listIterator();
        ListIterator<Integer> itRes = res.list.listIterator();

        int cur1 = 0;
        int cur2 = 0;
        boolean cursWasNotEquals = false;

        while (true){
            if (!it1.hasNext()){
                    if (cur1 < cur2) {
                        itRes.add(cur1);
                        break;
                    }
                    if (cur1 == cur2)
                        return res;
                    while (it2.hasNext()){
                        cur2 = it2.next();
                        if (cur1 == cur2)
                            return res;
                        if (cur1 < cur2){
                            itRes.add(cur1);
                            return res;
                        }
                    }
                    break;
            }
            if (!it2.hasNext()){
                if (cur1 != cur2)
                    itRes.add(cur1);
                while (it1.hasNext()){
                    itRes.add(it1.next());
                }
                break;
            }
            if (cur1 < cur2){
                itRes.add(cur1);
                cur1 = it1.next();
                cursWasNotEquals = true;
                continue;
            }
            if (cur1 > cur2){
                cur2 = it2.next();
                cursWasNotEquals = true;
                continue;
            }
            if (!cursWasNotEquals) {
                cur1 = it1.next();
                cur2 = it2.next();
            }
            cursWasNotEquals = false;
        }
        return res;
    }

        public String toString() {
        return list.toString();
    }

    public int hashCode() {
        int prime = 37;
        if (repeat) {
            prime += 2;
        }
        return list.hashCode() + prime;
    }

    public boolean equals(SortedIntegerList sl) {
        if (this == sl)
            return true;
        if ((sl == null) || (this.getClass() != sl.getClass()) || (this.repeat != sl.repeat))
            return false;
        if (this.list.size() != sl.list.size())
            return false;
        ListIterator<Integer> it1 = this.list.listIterator();
        ListIterator<Integer> it2 = sl.list.listIterator();
        while (it1.hasNext()) {
            if (it1.next() != it2.next())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SortedIntegerList l1 = new SortedIntegerList(true);
        SortedIntegerList l12 = new SortedIntegerList(true);
        SortedIntegerList l2 = new SortedIntegerList(false);
        SortedIntegerList l3 = new SortedIntegerList(false);

        for (int i = 20; i >= 0; i--) {
            l1.add(i % 5);
            l12.add(i % 4);
            l2.add(i % 6);
            l3.add(i % 5);
        }

        System.out.println("list1: \n" + l1);
        System.out.println("list2 :\n" + l2);
        System.out.println("list3 :\n" + l3);
        System.out.println("list12 :\n" + l12);

        System.out.println("\nlist2.remove(list3): \n" + l2.remove(l3));
        System.out.println("list3.remove(list2): \n" + l3.remove(l2));
        System.out.println("list3.remove(list3): \n" + l3.remove(l3));
        System.out.println("list1.remove(list12): \n" + l1.remove(l12));
        System.out.println("list12.remove(list1): \n" + l12.remove(l1));

        l1.remove(2);
        l2.remove(5);

        System.out.println("\nafter l1.remove(2), l2.remove(5):");
        System.out.println("list1: \n" + l1);
        System.out.println("list2 :\n" + l2);
        System.out.println("list3 :\n" + l3);

        System.out.println("\nl2.equals(l3): " + l2.equals(l3));
        System.out.println("l1.equals(l3): " + l1.equals(l3));
        System.out.println("l1.equals(l2): " + l1.equals(l2));
        System.out.println("l3.equals(l3): " + l3.equals(l3));
    }
}
