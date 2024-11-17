import java.util.Random;

public class ParkingLotSimulation {
    private static final int PARKING_CAPACITY = 5;
    private static final int NUMBER_OF_CARS = 10;

    public static ConsoleColor getRandomColor() {
        ConsoleColor[] colors = ConsoleColor.values();
        int randomIndex = new Random().nextInt(colors.length);
        return colors[randomIndex];
    }
    public static void main(String[] args) {
        ParkingLotWN parkingLot = new ParkingLotWN(PARKING_CAPACITY);

        for (int i = 1; i <= NUMBER_OF_CARS; i++) {
            // Random color text for each car
            ConsoleColor randomColor = getRandomColor();
            new Car(parkingLot, "Car" + i, randomColor).start();
        }
    }
}