package com.example.herocompany.services;

import com.example.herocompany.dto.MailDto;
import com.example.herocompany.entities.Mail;
import com.example.herocompany.repositories.MailRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MailServices {

    final MailRepository mailRepository;

    public MailServices(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public ResponseEntity<Map<REnum,Object>> save(MailDto mailDto){
        Map<REnum,Object> hashMap = new LinkedHashMap<>();
        Mail mail = new Mail();
        mail.setMail(mailDto.getMail());
        mailRepository.save(mail);
        hashMap.put(REnum.status,true);
        hashMap.put(REnum.result,mail);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }


    }

