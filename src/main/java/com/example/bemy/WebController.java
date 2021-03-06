package com.example.bemy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private final static String FILE_URL = "Nhi.txt";

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/magic")
    public String magic(Model model) throws IOException {
        return "magic";
    }

    @PostMapping("/check")
    public String postMagic(Model model,
                            @RequestParam(name = "lover")String lover,
                            @RequestParam(name = "date")String date,
                            @RequestParam(name = "name")String name) throws IOException {

        List<String> list = new ArrayList<>();
        int check = 0;
        if(!name.equals("Bạch Thị Ngọc Nhi")){
            check = 1;
        }else if(!date.equals("14/01/2001")){
            check = 2;
        }else if(!lover.equals("Đỗ Tuấn Kiệt")){
            check =3;
        }
        if(check == 0){
            return "redirect:/magic";
        }else{
            return "error";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
