package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.SongWriter;
import com.example.demo.Repository.SongWriterRepository;

@RestController
@RequestMapping("/api/songwriters")
public class SongWriterController {
	   @Autowired
	    private SongWriterRepository songwriterRepository;

	    @GetMapping
	    public List<SongWriter> getAllSongWriters() {
	        return songwriterRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public SongWriter getSongWriterById(@PathVariable Long id) {
	        return songwriterRepository.findById(id).orElse(null);
	    }

	    @PostMapping
	    public SongWriter addSongWriter(@RequestBody SongWriter SongWriter) {
	        return songwriterRepository.save(SongWriter);
	    }

	    @PutMapping("/{id}")
	    public SongWriter updateSongWriter(@PathVariable Long id, @RequestBody SongWriter updatedSongWriter) {
	        return songwriterRepository.findById(id)
	                .map(songwriter -> {
	                    songwriter.setFirstName(updatedSongWriter.getFirstName());
	                    songwriter.setLastName(updatedSongWriter.getLastName());
	                    return songwriterRepository.save(songwriter);
	                })
	                .orElse(null);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteSongWriter(@PathVariable Long id) {
	        songwriterRepository.deleteById(id);
	    }
	


}
