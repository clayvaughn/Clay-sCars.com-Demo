/*
 *
 *
 *
 */

package rentalsystem;

public class Customer {

    // attributes
    private String id;
    private String name;
    private String phone;
    private String email;

    // constructor with parameters
    public Customer(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
