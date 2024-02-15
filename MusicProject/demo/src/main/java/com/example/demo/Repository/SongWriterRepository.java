package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.SongWriter;

public interface SongWriterRepository extends JpaRepository <SongWriter, Long>{

}