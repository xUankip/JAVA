package day3;

public class Customer implements Comparable<Customer> {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Customer customer) {
        if (customer.getId() == this.getId()){
            return 0;
        } else if (this.getId()>customer.getId()){
            return 1;
        } else{
            return -1;
        }
    }
}
