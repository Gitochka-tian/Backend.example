package com.example.SHIZA_BACK.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity //какой-то JPA сделает из этой сущности табличку в бд
@Table(name = "user")
public class UserEntity {

    @Id//Spring понимает, что есть id пользователя
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary_key AUTO_INCREMENT
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")//связь между кортежами//удаляем всё, что связано foreign key с Entity
    private List<TodoEntity> todos;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(){
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
