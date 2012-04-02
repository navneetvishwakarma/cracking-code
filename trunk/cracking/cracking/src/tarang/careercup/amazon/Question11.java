package tarang.careercup.amazon;


import com.sun.corba.se.spi.ior.iiop.MaxStreamFormatVersionComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * You have an infinite set of coordinates, find out the 10 points closest to the origin
 *
 * @author tdesai
 */
public class Question11 {

    PriorityQueue<Point> pq;
    int MAX_CAPACITY;

    public Question11(int max_capacity) {
        this.pq = new PriorityQueue<Point>();
        this.MAX_CAPACITY = max_capacity;
    }

    public List<Point> closestPoints(int N) {
        List<Point> points = new ArrayList<Point>();
        while(pq.size() == 0 || points.size() < N) {
            points.add(pq.poll());
        }
        return points;
    }

    public void addPoint(Point p) {
        this.pq.add(p);
        if(pq.size() > MAX_CAPACITY) {
            pq.poll();
        }
    }

    public static void main(String[] args) {
        Question11 q11 = new Question11(100);
        for(int i = 0; i < 10; i++) {
            q11.addPoint(new Point());
        }
        List<Point> closestPoints = q11.closestPoints(3);
        for(Point p : closestPoints) {
            System.out.println(p);
        }
    }
}

class Point implements Comparable {
    double x, y;

    public Point() {
        // random points
        Random random = new Random();
        x  = random.nextDouble() * 100;
        y  = random.nextDouble() * 100;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2.0) + Math.pow(this.y - that.y, 2.0));
    }

    public int compareTo(Object o) {
        Point ORIGIN = new Point(0, 0);

        double dist1 = distance(ORIGIN);
        double dist2 = ((Point) o).distance(ORIGIN);
        if(dist1 == dist2) {
            return 0;
        } else if(dist1 < dist2) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + distance(new Point(0, 0)) +
                '}';
    }
}
