
public class Car extends Thread {
    private ParkingLotWN parkingLotWN=null;
    public final ConsoleColor color;
    public boolean returningcar;

    public Car(ParkingLotWN parkingLot, String name, ConsoleColor color) {
        super(name);
        this.parkingLotWN = parkingLot;
        this.color=color;
        this.returningcar=false;
    }



    private void goforadrive() throws InterruptedException {
        System.out.println(ConsoleColor.RESET.getCode()+"  "+ Emoji.RUNNINGCAR.getCode()+"  "+this.color.getCode() + this.getName() + " is going for a drive around the city." + ConsoleColor.RESET.getCode());
        Thread.sleep((long) (Math.random() * 20000)); // Simulate time while going for a drive
    }
    private void awaitsinparking() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 50000)); // Simulate time spent in the parking lot
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.goforadrive();
                parkingLotWN.enter(this);
                this.awaitsinparking();
                parkingLotWN.exit(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}