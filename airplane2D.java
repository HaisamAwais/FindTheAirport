import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Airplane2D extends JPanel {
    private Airplane airport;
    private Airplane plane;
    private double angle;

    // Constructor to initialize the graphical panel
    public Airplane2D(Airplane airport, Airplane plane) {
        this.airport = airport;
        this.plane = plane;
        this.angle = 0;
    }

    // Method to update the plane's position and angle
    public void updatePlane(double angle, double distance) {
        this.angle = angle;
        plane.fly(angle, distance);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the airport
        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) airport.getX() - 15, (int) airport.getY() - 15, 30, 30);
        g2d.drawString("Airport", (int) airport.getX() - 15, (int) airport.getY() + 25);

        // Draw the plane as a circle with a line and arrow
        AffineTransform old = g2d.getTransform();
        g2d.translate(plane.getX(), plane.getY());
        g2d.rotate(Math.toRadians(angle));

        g2d.setColor(Color.RED);
        g2d.fillOval(-15, -15, 30, 30); // Draw the filled circle

        // Draw the line
        g2d.drawLine(0, 0, 30, 0); // Line extending from the circle

        // Draw the arrow at the end of the line
        g2d.fillPolygon(new int[]{30, 35, 30}, new int[]{-5, 0, 5}, 3); // Arrowhead

        g2d.setTransform(old);
        g2d.drawString("Plane", (int) plane.getX() - 15, (int) plane.getY() + 25);
    }
}
