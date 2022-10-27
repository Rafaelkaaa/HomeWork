package HW11;

import java.util.stream.Stream;

public class RandomNumbers {
    long randomNumber;

    private long generateRandomNumber(long c, long m, long a) {
        randomNumber = (((25214903917L * randomNumber) + c)) % m;
        return randomNumber;
    }

    public Stream<Long> generateStreamRandomNumber() {
        return Stream
                .iterate(10L,
                        n -> generateRandomNumber(11, 2 ^ 48, 25214903917L))
                .limit(1000);
    }
}
