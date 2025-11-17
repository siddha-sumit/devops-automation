package com.parmeshthi.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devops")
public class AppController {

    @GetMapping
    public String getOperation(){
        return "Thi is the devops integration application";
    }
}
