package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Producer;

public interface ProducerRepository extends JpaRepository <Producer, Long>{

}