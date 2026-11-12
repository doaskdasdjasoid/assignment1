public class CarTest {
    private static void reportResult(String testName, boolean success) {
        System.out.println(
                (success ? "SUCCESS: " : "FAILURE: ") + testName
        );
    }

    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();

        fastSaab.setTurboOn();
        slowSaab.setTurboOff();

        fastSaab.gas(0.5);
        slowSaab.gas(0.5);

        boolean result =
                slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();

        reportResult("Turbo yields more speed", result);
    }

    private static void testStartEngine() {
        Volvo240 car = new Volvo240();

        car.startEngine();

        boolean result = car.getCurrentSpeed() == 0.1;

        reportResult("Engine starts correctly", result);
    }

    private static void testStopEngine() {
        Volvo240 car = new Volvo240();

        car.startEngine();
        car.stopEngine();

        boolean result = car.getCurrentSpeed() == 0;

        reportResult("Engine stops correctly", result);
    }
    private static void testSpeedLimits() {
        Volvo240 car = new Volvo240();

        car.gas(2);
        boolean invalidGas = car.getCurrentSpeed() == 0;

        car.brake(1);
        boolean noNegativeSpeed = car.getCurrentSpeed() == 0;

        reportResult("Speed limits", invalidGas && noNegativeSpeed);
    }
    private static void testMaxSpeed() {
        Volvo240 car = new Volvo240();

        for (int i = 0; i < 200; i++) {
            car.gas(1);
        }

        boolean result = car.getCurrentSpeed() <= car.getEnginePower();

        reportResult("Maximum speed respected", result);
    }

    public static void main(String[] args) {
        testTurbo();
        testStartEngine();
        testStopEngine();
        testSpeedLimits();
        testMaxSpeed();
    }
}

