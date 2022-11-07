package com.bookshop.BookShop.Controllers;//package com.flamup.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/")
public class TestGetController {

    @GetMapping("sexy")
    public HashMap<String, String> sampleGet(){
        HashMap<String, String> maps = new HashMap<>();
        maps.put("WOW", "COOL");
        maps.put("SEXY", "BITCH");
        return maps;
    }

}
