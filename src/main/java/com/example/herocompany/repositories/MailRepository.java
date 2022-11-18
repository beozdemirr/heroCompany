package com.example.herocompany.repositories;

import com.example.herocompany.entities.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}