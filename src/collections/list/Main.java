package collections.list;

import static jdk.nashorn.internal.objects.Global.println;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(9);
        list.add(88);
        list.add(56);
        list.add(6);
        list.sort(Comparator.reverseOrder());
        list.add(4,5);
        System.out.println(list.get(2));
        list.forEach(System.out::println);
    }
}
