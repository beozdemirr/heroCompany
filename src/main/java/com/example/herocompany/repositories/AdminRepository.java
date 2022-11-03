package com.example.herocompany.repositories;

import com.example.herocompany.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
 //   Optional<Admin> findByPassword(String password);
 //   Optional<Admin> findByEmailEndingWithIgnoreCase(String email);

}