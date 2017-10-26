class Punkt {
    double x;
    double y;
    double z;

    Punkt(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "[x: " + x + ", y: " + y + ", z: " + z + "]";
    }

    void przesun(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }
}