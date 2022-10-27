package HW11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameChange {

    public List<String> addIndexToName(List<String> names) {
        AtomicInteger n = new AtomicInteger(1);
        Stream<String> namesStream = names.stream().map((name -> n.getAndAdd(2) + ". " + name));

        return namesStream.collect(Collectors.toList());
    }

    public List<String> sortNames(List<String> names) {
        Stream<String> namesStream = names.stream().map(String::toUpperCase).sorted();
        return namesStream.collect(Collectors.toList());
    }
}
class  TestNameChange{
    public static void main(String[] args) {
        NameChange nameChange = new NameChange();
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Andriy");
        names.add("Petro");

        System.out.println(nameChange.addIndexToName(names));
        System.out.println(nameChange.sortNames(names));
    }
}
