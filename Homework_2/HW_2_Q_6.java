import java.io.*;

class ParallelLinesException extends Exception {
    public ParallelLinesException(String msg) {
        super(msg);
    }
}

class Line {
    double slope;
    double y;

    Line(double slope, double y) {
        this.slope = slope;
        this.y = y;
    }

    public static void intersection(Line l1, Line l2) throws ParallelLinesException {
        if(l1.slope == l2.slope) {
            throw new ParallelLinesException("Line (Slope : " + l1.slope +" , y-intercept : " + l1.y + ") and Line (Slope : " + l2.slope + " , y-intercept : " + l2.y + ") are parallel.");
        } else {
            double x_i = (l2.y - l1.y) / (l1.slope - l2.slope);
            double y_i = (l1.slope * x_i) + l1.y;
            System.out.println("Point of Interection (x, y) : (" + x_i + ", " + y_i + ")");
        }
    }

}

public class HW_2_Q_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Slope1, slope2, intercept1 and intercept2 : ");
        double s1 = Double.parseDouble(buf.readLine());
        double s2 = Double.parseDouble(buf.readLine());
        double y1 = Double.parseDouble(buf.readLine());
        double y2 = Double.parseDouble(buf.readLine());

        Line l1 = new Line(s1, y1);
        Line l2 = new Line(s2, y2);
        try {
            Line.intersection(l1, l2);
        } catch(ParallelLinesException p) {
            System.out.println("Exception : " + p.getMessage());
        }
    }
}
