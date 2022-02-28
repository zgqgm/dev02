package 基础实例.线程.自定义卖货;
//自定义货物
public class Goods {
    private String name;
    private float price;

    // 是否需要被生产
    private boolean isProduct;

    public Goods() {
    }

    public Goods(String name, float price, boolean isProduct) {
        this.name = name;
        this.price = price;
        this.isProduct = isProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isProduct() {
        return isProduct;
    }

    public void setProduct(boolean isProduct) {
        this.isProduct = isProduct;
    }
}
