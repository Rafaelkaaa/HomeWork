package HW11;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersFromArrayToString {
    List <String> numbersStr;

    public NumbersFromArrayToString(List<String> numbersStr) {
        this.numbersStr = numbersStr;
    }

    private String toArrayIntegers() {

        Stream<String> numbersStream = numbersStr.stream()
                .map(numbers-> Arrays.asList(numbers.split(", ")))
                .flatMap(Collection::stream)
                .sorted();

        return numbersStream.collect(Collectors.joining());
    }
}