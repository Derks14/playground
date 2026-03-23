package generics;

public class Product<T, U> {
    T item;
    U price;

    public Product(T item, U price) {
        this.item = item;
        this.price = price;
    }


    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public U getPrice() {
        return price;
    }

    public void setPrice(U price) {
        this.price = price;
    }
}
