package com.example.SHIZA_BACK.repository;

import com.example.SHIZA_BACK.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
