package com.api.retotec.models;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "futbolista")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate dated;

    @Column
    private String charact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idp")
    private UserPosition idp;



    public String getCharact() {
        return charact;
    }

    public void setCharact(String charact) {
        this.charact = charact;
    }


    public LocalDate getDated() {
        return dated;
    }

    public UserPosition getPosition() {
        return idp;
    }

    public void setPosition(UserPosition idp) {
        this.idp = idp;
    }


    public void setDated(LocalDate dated) {
        this.dated = dated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
            }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
