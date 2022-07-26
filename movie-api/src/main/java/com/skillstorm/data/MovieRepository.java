package com.skillstorm.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	public List<Movie> findTop5ByOrderByIdAsc();
}
