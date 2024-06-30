import java.util.Date;
import java.util.Stack;

public class Invoice {
//    Hóa đơn (mã hóa đơn, mã nv bán hàng, mã KH nếu có, danh sách mặt hàng, tổng giá, ngày mua)
    private int Id;
    private SalesEmployee salesEmployee;
    private Customer customer;
    private Stack<Product> products;
    private Date date;
    private int totalPrice;
    private int log10;

    public Invoice(int id, SalesEmployee salesEmployee, Customer customer) {
        Id = id;
        this.salesEmployee = salesEmployee;
        this.customer = customer;
        this.date = new Date();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SalesEmployee getSalesEmployee() {
        return salesEmployee;
    }

    public void setSalesEmployee(SalesEmployee salesEmployee) {
        this.salesEmployee = salesEmployee;
    }

    public Stack<Product> getProduct() {
        return products;
    }

    public void setProduct(Stack<Product> product) {
        this.products = product;
    }

    public void addProduct(Product product) {
        this.products.push(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public Date getDate() {
        return date;
    }

    public void updateTotalPrice() {
        int totalPrice = 0;
        int log = 0;
        for (Product p: products) {
            int priceDecimal = p.getPriceDecimal();
            int log10 = p.getLog10();
            if(log10 > log){
                totalPrice *= (int) Math.pow(10, log10 -log);
            }
            totalPrice += priceDecimal*p.getQuantity();
        }
        System.out.println("Total Price: " + totalPrice);
    }
}