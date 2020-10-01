import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testConstructor() {
        // construct a point and use the getter to ensure fields were set
        Point origin = new Point(0 ,0);

        // verify Point was constructed properly
        // message: error message | expected: what you expect the output to be
        // origin.getX(): method we are testing | delta: tolerances for a double
        assertEquals("Point x coordinate incorrect", 0.0, origin.getX(), 0.0);
        assertEquals("Point y coordinate incorrect", 0.0, origin.getY(), 0.0);
    }

    @Test
    public void testToString() {
        Point p1 = new Point(-1,3);
        assertEquals("toString() failed", "Point{x=-1.0, y=3.0}", p1.toString());
    }

}