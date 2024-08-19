public class Airplane {
    private double x;
    private double y;

    // Constructor to initialize the Airplane at a specific location
    public Airplane(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method to fly the airplane in a specific direction and distance
    public void fly(double angle, double distance) {
        x += Math.cos(Math.toRadians(angle)) * distance;
        y += Math.sin(Math.toRadians(angle)) * distance;
    }

    // Method to calculate the distance between this airplane and another airplane
    public double distanceBetween(Airplane plane) {
        return Math.sqrt(Math.pow(x - plane.x, 2) + Math.pow(y - plane.y, 2));
    }

    // Getter for x coordinate
    public double getX() {
        return x;
    }

    // Getter for y coordinate
    public double getY() {
        return y;
    }
}
