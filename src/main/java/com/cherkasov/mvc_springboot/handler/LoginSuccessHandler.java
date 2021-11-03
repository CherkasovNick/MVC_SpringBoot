package com.cherkasov.mvc_springboot.handler;

import com.cherkasov.mvc_springboot.models.User;
import com.cherkasov.mvc_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

//    @Autowired
//    private User user;

    @Autowired
    public LoginSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//        Set<String> roles = AuthorityUtils.authorityListToSet(user.getAuthorities());
        System.out.println("star authorization");
        User user = userService.getUserByUsername(authentication.getName());
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
            System.out.println("as admin");
        } else {
            httpServletResponse.sendRedirect("/users/" + user.getId());
            System.out.println("as user");
        }
    }
}
