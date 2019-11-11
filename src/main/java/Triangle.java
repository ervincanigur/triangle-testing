public class Triangle {
    private float a, b, c;
    private boolean valid, equilateral, isosceles, scalene, right;

    // Constructors
    public Triangle(float side1, float side2, float side3) {
        this.a = side1;
        this.b = side2;
        this.c = side3;
        calculateTriangleType();
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.a = calculateDistance(point1, point2);
        this.b = calculateDistance(point2, point3);
        this.c = calculateDistance(point3, point1);
        calculateTriangleType();
    }

    /**
     * Getter method for validity of triangle
     *
     * @return triangle is valid or not
     */
    boolean isValid() {
        return valid;
    }

    public float getArea() {
        float semi = (a + b + c) / 2.0f;
        return (float) Math.sqrt(semi * (semi - a) * (semi - b) * (semi - c));
    }

    /**
     * Calculate distance between two points
     *
     * @param point1
     * @param point2
     * @return distance between two points
     */
    private float calculateDistance(Point point1, Point point2) {
        return (float) Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    /*
     * Four types of triangles
     * Equilateral: a triangle with three congruent sides (3 equal sides)
     * Isosceles: a triangle with exactly two congruent sides (two equal sides)
     * Scalene: a triangle with no congruent sides. (no equal sides)
     * Right: a triangle with a 90◦ angle. (a^2+b^2=c^2)
     * NOTE: Triangle can be right and isosceles or right and scalene.
     */
    private void calculateTriangleType() {
        // Validate inputs, checking if sides are below zero or do not form a valid triangle
        if (a < 0 || b < 0 || c < 0) {
            valid = false;
            return;
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            valid = false;
            return;
        } else {
            valid = true;
        }

        // equilateral, all sides equal
        if (a == b && a == c) {
            equilateral = true;
            return;
        }

        // isosceles or scalene, either 2 sides equal or no sides equal
        if (a == b || b == c || c == a)
            isosceles = true;
        else if (a != b && a != c && b != c)
            scalene = true;

        // right, first find the longest side then using a^2 + b^2 = c^2 to see if right triangle
        float temp;
        if (c < a) {
            temp = c;
            c = a;
            a = temp;
        }
        if (c < b) {
            temp = c;
            c = b;
            b = temp;
        }

        if (a * a + b * b == (float) Math.ceil(c * c))
            right = true;
    }

    @Override
    public String toString() {
        return "Triangle: " + a + " " + b + " " + c + "\n"
                + "-- Triangle Type --" + "\n"
                + "Valid: " + valid
                + " Equal: " + equilateral + "\n"
                + "Isosceles: " + isosceles
                + " Scalene: " + scalene + "\n"
                + "Right: " + right;
    }
}
