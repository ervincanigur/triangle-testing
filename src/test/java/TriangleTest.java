import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void TrianglePass() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertTrue(triangle.isValid());
    }

    @Test
    public void TriangleFail() {
        Triangle triangle = new Triangle(5, 8, 3);
        assertFalse(triangle.isValid());
    }

    @Test
    public void TrianglePoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(1,0);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertTrue(triangle.isValid());
    }
}
