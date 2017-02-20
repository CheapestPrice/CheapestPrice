package edu.eci.cosw.cheapestPrice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Paula on 20/02/2017.
 */
@RestController
public class UserController {
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
}
