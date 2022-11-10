package HW13;

public class User {
    private Integer id;
    private String name;
    private String UserName;
    private String email;
    private Address address;
    private String phone;
    private String site;
    private Company company;


    public User(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
