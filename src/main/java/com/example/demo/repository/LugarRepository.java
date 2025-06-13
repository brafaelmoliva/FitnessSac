package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Integer>{

}