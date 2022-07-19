package com.skillstorm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Dinosaur;

@Repository
public interface DinosaurRepository extends JpaRepository<Dinosaur, Integer> {

}
