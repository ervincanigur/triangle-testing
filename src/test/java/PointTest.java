import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void PointTest() {
        Point point = new Point(10, 10);
        assertEquals(point.getX(), 10, 0);
        assertEquals(point.getY(), 10, 0);
    }

    @Test
    public void PointGetX() {
        Point point = new Point(100, 0);
        assertEquals(point.getX(), 100, 0);
    }

    @Test
    public void PointGetY() {
        Point point = new Point(0, 100);
        assertEquals(point.getY(), 100, 0);
    }
}
