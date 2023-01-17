package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {
    // [key]user // [value]UserController
    private Map<String, Controller> mappings = new HashMap<>();

    void init(){
        // 경로 입력 안되면 HomeController가 기본이 되게
        mappings.put("/", new HomeController());
    }
    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }
}
