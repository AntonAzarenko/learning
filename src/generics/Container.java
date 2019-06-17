package generics;

public class Container<T extends Product> {

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
