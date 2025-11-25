package com.example.library.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Matter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String matterName;
    private byte credits;

    @ManyToMany(mappedBy = "matters")
    private List<Student> students;

    public Matter() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public byte getCredits() {
        return credits;
    }

    public void setCredits(byte credits) {
        this.credits = credits;
    }
}
