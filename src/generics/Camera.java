package generics;

public class Camera extends Product<Camera> {

    private int pixel;

    @Override
    boolean subCompare(Camera camera) {
        return false;
    }

    @Override
    public int compareTo(Camera o) {
        return 0;
    }
}
