package dev.secu.SSO.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String main(OAuth2AuthenticationToken auth2AuthenticationToken) {
        logger.info(String.valueOf(auth2AuthenticationToken.getPrincipal()));

        return "main.html";
    }
}
