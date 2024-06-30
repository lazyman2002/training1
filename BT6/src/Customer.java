import java.util.Objects;

public class Customer {
    private String CustomerID;
    private int CustomerAge;
    private String CustomerGender;

    public Customer(String CustomerID, int CustomerAge, String CustomerGender) {
        this.CustomerID = CustomerID;
        this.CustomerAge = CustomerAge;
        this.CustomerGender = CustomerGender;
    }
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public int getCustomerAge() {
        return CustomerAge;
    }

    public void setCustomerAge(int customerAge) {
        CustomerAge = customerAge;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(CustomerID, customer.CustomerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerID, CustomerAge, CustomerGender);
    }
}

