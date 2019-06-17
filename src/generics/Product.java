package generics;

public abstract  class Product<T extends Product<T>> implements Comparable<T>  {

    private int price;

    abstract boolean subCompare(T t);

}
