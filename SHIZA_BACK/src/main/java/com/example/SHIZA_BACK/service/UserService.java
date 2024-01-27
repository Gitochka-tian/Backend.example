package com.example.SHIZA_BACK.service;

import com.example.SHIZA_BACK.entity.UserEntity;
import com.example.SHIZA_BACK.exception.UserAlreadyExistException;
import com.example.SHIZA_BACK.exception.UserNotFoundException;
import com.example.SHIZA_BACK.model.User;
import com.example.SHIZA_BACK.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired//аннотация для того, чтобы Spring внедрил объект этого класса сюда
    private UserRepo userRepo;//теперь этот репозиторий мы будем использовать внутри контроллера

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {//добавили ошибку в сигнатуру, чтобы потом обработать её в try-catch
        if(userRepo.findByUsername(user.getUsername()) !=null){//если там лежит не null, значит пользователь что-то нашёл
            throw new UserAlreadyExistException("Пользователь с этим именем уже существует");
        };
        return userRepo.save(user);//функция save возвращает нам entity  с добавленным id'шником
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();//вынесем получение пользователя, чтобы дважды не стучаться в бд
        if(user == null){
            throw new UserNotFoundException("Пользователь не был найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
