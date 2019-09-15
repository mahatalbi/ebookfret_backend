package com.htakemoto.domain;


import javax.persistence.*;

@Entity
public class MaritimeAgent{
    @Id
    @SequenceGenerator(name="user_generator", sequenceName = "user_generator", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "user_generator")
    private Long id;

    @Column(name="first_name", nullable=false, length=50)
    private String firstname;

    @Column(name="last_name", length=20)
    private String lastname;

    public MaritimeAgent() {
    }

    public MaritimeAgent(Long id){
        this.id=id;
    }
    public void setUserId(long userId) {
        this.id=userId;    }

    public Long getUserId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
