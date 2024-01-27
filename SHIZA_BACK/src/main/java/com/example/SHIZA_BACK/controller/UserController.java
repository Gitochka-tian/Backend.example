package com.example.SHIZA_BACK.controller;

import com.example.SHIZA_BACK.entity.UserEntity;
import com.example.SHIZA_BACK.exception.UserAlreadyExistException;
import com.example.SHIZA_BACK.exception.UserNotFoundException;
import com.example.SHIZA_BACK.repository.UserRepo;
import com.example.SHIZA_BACK.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired//аннотация для того, чтобы Spring внедрил объект этого класса сюда
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){//функция, иммитирующая регистрацию пользователя
        try{
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранён");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
            try{
                return ResponseEntity.ok(userService.delete(id));
            }  catch (Exception e){
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
    }
}
