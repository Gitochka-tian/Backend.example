package com.example.SHIZA_BACK.service;

import com.example.SHIZA_BACK.entity.TodoEntity;
import com.example.SHIZA_BACK.entity.UserEntity;
import com.example.SHIZA_BACK.model.Todo;
import com.example.SHIZA_BACK.repository.TodoRepo;
import com.example.SHIZA_BACK.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired//еджектим только что созданный репозиторий TodoRepo
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }
    public Todo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));//Эта функция нужна как для создания, так и для удаления
    }
}
