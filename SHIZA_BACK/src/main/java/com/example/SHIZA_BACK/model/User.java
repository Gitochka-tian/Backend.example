package com.example.SHIZA_BACK.model;

import com.example.SHIZA_BACK.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {//Сущности, которые взаимодействуют с базой данных и объекты,
    //которыми мы обмениваемся с пользователем - ЭТО РАЗНЫЕ КЛАССЫ
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity){//Статичная Функция-конвертер,принимающая сущность, выдающая модель
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));//итерируется по массиву и вызывает функцию ToModel для каждого элемента
        return model;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
