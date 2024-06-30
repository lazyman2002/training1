public class Product {

//    Mặt hàng (mã hàng hóa, tên hàng hóa, phân loại, giá)
    private String Id;
    private String name;
    private String type;
    private int log10;
    private int priceDecimal;
    private int quantity;
    public Product(String Id, String name, String type, int log10, int priceDecimal) {
        this.Id = Id;
        this.name = name;
        this.type = type;
        this.log10 = log10;
        this.priceDecimal = priceDecimal;
        this.quantity = 0;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLog10() {
        return log10;
    }

    public void setLog10(int log10) {
        this.log10 = log10;
    }

    public int getPriceDecimal() {
        return priceDecimal;
    }

    public void setPriceDecimal(int priceDecimal) {
        this.priceDecimal = priceDecimal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
