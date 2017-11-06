package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String DiceRoll(){
        return "role-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String RandomDie(@PathVariable int n, Model viewModel){
        String thatsIt = "Gottie";
        String notIt = "Try again";
        int range = (6 - 1) + 1;
        int dice = (int) (Math.random() * range) + 1;
        viewModel.addAttribute("n", n);
        viewModel.addAttribute("dice", dice);
        if (n == dice){
            viewModel.addAttribute("thatsIt",thatsIt);
        } else {
            viewModel.addAttribute("notIt", notIt);
        }
        return "random-die";
    }
}
