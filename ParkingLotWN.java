

import java.util.LinkedList;
import java.util.Queue;



public class ParkingLotWN {
    private final int capacity;
    private final Queue<Car> queue;
    private int parkedCars;

    public ParkingLotWN(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.parkedCars = 0;

    }

    public synchronized void enter(Car car) throws InterruptedException {

        while (parkedCars >= capacity) {
            queue.add(car);
            System.out.println(Emoji.TRAFFICLIGHT.getCode() + Emoji.REDSPOTLIGHT.getCode() + "  " + car.color.getCode() + car.getName() + " is waiting to enter." + ConsoleColor.RESET.getCode() + " Queue: " + getWaitingQueue());
            wait();
            System.out.println(Emoji.TRAFFICLIGHT.getCode() + Emoji.GREENSPOTLIGHT.getCode() + "  " + car.color.getCode() + car.getName() + " is going to enter parking." + ConsoleColor.RESET.getCode());
        }
        parkedCars++;
        if (car.returningcar)
            System.out.print(Emoji.GREETING.getCode() + "  Returning car!!  ----- ");
        System.out.println(Emoji.PARKINGLOT.getCode() + "  " + car.color.getCode() + car.getName() + " has entered the parking lot. Parked cars: " + parkedCars + ". " + ConsoleColor.RESET.getCode() + "Queue: " + getWaitingQueue());
    }

    public synchronized void exit(Car car) throws InterruptedException {
        parkedCars--;
        System.out.println(car.color.getCode() + car.getName() + " has exited the parking lot. " + ConsoleColor.RESET.getCode() + "Parked cars: " + parkedCars);
        car.returningcar = true;
        if (!queue.isEmpty()) {
            Car nextCar = queue.poll();
            notifyAll();
        }
    }

    private synchronized String getWaitingQueue() {
        StringBuilder queueString = new StringBuilder();
        for (Car car : queue) {
            queueString.append(car.color.getCode() + car.getName()).append(ConsoleColor.RESET.getCode()).append(" ");
        }
        //return queueString.toString().trim();
        return queueString.toString();
    }
}
