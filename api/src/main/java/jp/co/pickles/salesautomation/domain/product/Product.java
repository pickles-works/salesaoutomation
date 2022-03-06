package jp.co.pickles.salesautomation.domain.product;

public class Product {
    private final ProductID id;
    private final ProductName name;
    private final ProductUsed type;
    private final ProductLimitOfQuantity limitOfQuantity;
    private final ProductCode code;

    private Product(ProductID id, ProductName name, ProductUsed type, ProductLimitOfQuantity limitOfQuantity, ProductCode code) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.limitOfQuantity = limitOfQuantity;
        this.code = code;
    }

    // MyBatis や Jackson などから呼び出されるデフォルトコンストラクタ
    public Product() {
        this.id = new ProductID();
        this.name = new ProductName();
        this.type = new ProductUsed();
        this.limitOfQuantity = new ProductLimitOfQuantity();
        this.code = new ProductCode();
    }

    public static Product create() {
        return new Product();
    }
}
