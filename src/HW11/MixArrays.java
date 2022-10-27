package HW11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MixArrays {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        List<T> result = new ArrayList<T>();
        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return result.stream();
    }
}

class TestMixArrays{
    public static void main(String[] args) {
        MixArrays mixArrays = new MixArrays();
        Stream first = Stream.of(1, 2, 2, 3, 4, 6, 8);
        Stream second = Stream.of(10, 20, 20, 30, 40, 60, 80, 90, 70, 50);
        System.out.println(mixArrays.zip(first, second).collect(Collectors.toList()));
    }
}


