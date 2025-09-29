package kr.co.sboard.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping(value = {"/", "/index"})
    public String index(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            return "forward:/article/list";
        }else{
            return "index";
        }
    }
}
