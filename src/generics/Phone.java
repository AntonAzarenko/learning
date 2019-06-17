package generics;

public class Phone extends Product<Phone>{
    private int displaySize;

    @Override
    boolean subCompare(Phone phone) {
        return false;
    }

    @Override
    public int compareTo(Phone o) {
        return 0;
    }
}
