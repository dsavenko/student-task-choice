package ru.nsu.dsavenko.taskchoice;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static class Point {
        double x;
        double y;

        public Point() {
            x = Math.random() * 100;
            y = Math.random() * 100;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class Circle {
        Point center;
        double radius;

        public Circle(Point center) {
            this.center = center;
            this.radius = Math.random() * 5;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "center=" + center +
                    ", radius=" + radius +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            points.add(new Point());
        }
        double maxDistance = 30;
        List<Circle> circles = new ArrayList<>();
        for (Point p : points) {
            double distance = Math.sqrt(p.x*p.x + p.y*p.y);
            if (distance-maxDistance < 0.0000001) {
                circles.add(new Circle(p));
            }
        }
        double area = 0;
        for (Circle c : circles) {
            area += Math.PI*c.radius*c.radius;
        }
        System.out.println(circles.size() + " circles, total area: " + area);
    }
}
