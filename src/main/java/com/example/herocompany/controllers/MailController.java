package com.example.herocompany.controllers;


import com.example.herocompany.dto.MailDto;
import com.example.herocompany.entities.Mail;
import com.example.herocompany.services.MailServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    final MailServices mailServices;

    public MailController(MailServices mailServices) {
        this.mailServices = mailServices;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody MailDto mailDto){
        return mailServices.save(mailDto);
    }


}
