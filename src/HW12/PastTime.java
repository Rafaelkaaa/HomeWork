package HW12;

import static java.lang.Thread.sleep;

public class PastTime {

    final long TimeFirstIteration = System.currentTimeMillis();

    Thread wait1second = new Thread(() -> {
        while (true) {
            printEveryTime
                    (1000,
                            Long.toString(System.currentTimeMillis() - TimeFirstIteration));
        }
    }
    );
    Thread wait5second = new Thread(() -> {
        while (true) {
            printEveryTime
                    (5000, "5 second has passed");
        }
    }
    );

    private void printEveryTime(int ms, String printMassage) {
        try {
            sleep(ms);
            System.out.println(printMassage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestPastTime {
    public static void main(String[] args) {
        PastTime pastTime = new PastTime();
        pastTime.wait5second.start();
        pastTime.wait1second.start();
    }
}

