package contacts.contact;

import contacts.strategies.BehaviourStrategy;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Contact implements Serializable {
    private String name;
    private String number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    BehaviourStrategy strategy;

    public Contact() {
        this.createdAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void setNumber(String number) {
        this.number = number;
        this.updatedAt = LocalDateTime.now();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return name;
    }

    public void info() {
        if (this instanceof Person) {
            strategy.info((Person) this);
        } else if (this instanceof Organization) {
            strategy.info((Organization) this);
        }
    }

    public void edit() {
        if (this instanceof Person) {
            strategy.edit((Person) this);
        } else if (this instanceof Organization) {
            strategy.edit((Organization) this);
        }
    }

    public boolean search(String query) {
        if (this instanceof Person) {
            return strategy.search((Person) this, query);
        } else if (this instanceof Organization) {
            return strategy.search((Organization) this, query);
        }
        return false;
    }
}
