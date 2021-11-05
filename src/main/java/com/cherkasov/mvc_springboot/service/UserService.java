package com.cherkasov.mvc_springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.cherkasov.mvc_springboot.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user, String[] selectedRoles);
    List<User> getAll();
    User getOne(Long id);
    User update(User updatedUser, String[] selectedRoles);
    void delete(Long id);
    User getUserByUsername(String name);
}
