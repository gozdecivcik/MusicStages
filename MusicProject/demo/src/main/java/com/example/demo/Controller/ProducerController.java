package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Producer;
import com.example.demo.Repository.ProducerRepository;
import java.util.List;
@RestController
@RequestMapping("/api/producers")
public class ProducerController {
    @Autowired
    private ProducerRepository producerRepository;

    @GetMapping
    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producer getProducerById(@PathVariable Long id) {
        return producerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Producer addProducer(@RequestBody Producer producer) {
        return producerRepository.save(producer);
    }

    @PutMapping("/{id}")
    public Producer updateProducer(@PathVariable Long id, @RequestBody Producer updatedProducer) {
        return producerRepository.findById(id)
                .map(producer -> {
                    producer.setName(updatedProducer.getName());
                    return producerRepository.save(producer);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProducer(@PathVariable Long id) {
        producerRepository.deleteById(id);
    }
}
