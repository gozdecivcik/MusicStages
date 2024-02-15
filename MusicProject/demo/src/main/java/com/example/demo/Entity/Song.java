package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Song {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    private String description;

	    @ManyToMany
	    @JoinTable(
	            name = "song_songwriter",
	            joinColumns = @JoinColumn(name = "song_id"),
	            inverseJoinColumns = @JoinColumn(name = "songwriter_id"))
	    private Set<SongWriter> songwriters = new HashSet<>();

	    @ManyToOne
	    @JoinColumn(name = "producer_id")
	    private Producer producer;

	    @ManyToMany
	    @JoinTable(
	            name = "song_genre",
	            joinColumns = @JoinColumn(name = "song_id"),
	            inverseJoinColumns = @JoinColumn(name = "genre_id"))
	    private Set<Genre> genres= new HashSet<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Set<SongWriter> getSongWriters() {
			return songwriters;
		}

		public void setSongWriters(Set<SongWriter> songwriters) {
			this.songwriters = songwriters;
		}

		public Producer getProducer() {
			return producer;
		}

		public void setProducer(Producer producer) {
			this.producer = producer;
		}

		public Set<Genre> getGenres() {
			return genres;
		}

		public void setGenres(Set<Genre> genres) {
			this.genres = genres;
		}

	    


}
