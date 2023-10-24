package contacts.contact;

import contacts.strategies.OrganizationBehaviourStrategy;

import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;

    public Organization() {
        super();
        this.strategy = new OrganizationBehaviourStrategy();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public void info() {
        strategy.info(this);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
