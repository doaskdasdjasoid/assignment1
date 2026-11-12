import java.awt.Color;
public abstract class Car implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color ;
    private String modelName;
    private double x=0;
    private double y=0;
    private int direction=0;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.color=color;
        this.modelName=modelName;
        this.currentSpeed=0;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color=color ;
    }
    public void startEngine(){
        currentSpeed=0.1;
    }
    public void stopEngine(){
        currentSpeed=0;
    }
    public abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(
                enginePower,
                currentSpeed + speedFactor() * amount
        );
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(
                0,
                currentSpeed - speedFactor() * amount
        );
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public void move() {
        switch (direction) {
            case 0:
                y += currentSpeed;
                break;
            case 1:
                x += currentSpeed;
                break;
            case 2:
                y -= currentSpeed;
                break;
            case 3:
                x -= currentSpeed;
                break;
        }
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
    }


    public void turnLeft() {
        direction = (direction + 3) % 4;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }
}

