package org.agoncal.quarkus.jpa;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "e_mail", nullable = false)
    private String email;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    public Customer(String name, String last_name, String email) {
        this.firstName = name;
        this.lastName = last_name;
        this.email = email;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
