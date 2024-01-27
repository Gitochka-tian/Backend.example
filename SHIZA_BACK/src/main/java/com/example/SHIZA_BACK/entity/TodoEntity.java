package com.example.SHIZA_BACK.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class TodoEntity {//тудутудутудутудутудутудутудутудутудутдутудутудутудутудутудутудутуду
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private Boolean completed;
    private String opisanie;

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    public TodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
