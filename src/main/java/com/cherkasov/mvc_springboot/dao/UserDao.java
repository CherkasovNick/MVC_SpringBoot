package com.cherkasov.mvc_springboot.dao;



import com.cherkasov.mvc_springboot.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAll();
    User getOne(Long id);
    User update(User updatedUser);
    void delete(Long id);
    User getUserByUsername(String name);
}
