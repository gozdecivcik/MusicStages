package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Genre;

public interface GenreRepository extends JpaRepository <Genre, Long>{

}