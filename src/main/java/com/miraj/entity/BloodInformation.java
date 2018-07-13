package com.miraj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blood_information")
public class BloodInformation implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blood_information_id")
    private int bloodInformationId;

    @Column(name = "blood_group")
    private String bloodGroup;

    //bi directional relation with User
    @OneToMany(mappedBy = "bloodInformation")
    private List<User> user;

    public int getBloodInformationId() {
        return bloodInformationId;
    }

    public void setBloodInformationId(int bloodInformationId) {
        this.bloodInformationId = bloodInformationId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

}
