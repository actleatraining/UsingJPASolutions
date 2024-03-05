package com.example.SpringBootIntroductionDemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    List<Dog> findByName(String name);

    List<Dog> findByAgeGreaterThan(int age);

    List<Dog> findByNameAndAgeGreaterThan(String name, int age);

    @Query("SELECT d FROM Dog d WHERE d.age = ?1")
    List<Dog> findDogsWithQueryAge(int age);

    // Alternative version using nativeQuery, that is using "normal" SQL
    @Query(value = "SELECT * FROM DOG WHERE AGE = ?1", nativeQuery = true)
    List<Dog> findDogsWithQueryAgeNative(int age);

}
