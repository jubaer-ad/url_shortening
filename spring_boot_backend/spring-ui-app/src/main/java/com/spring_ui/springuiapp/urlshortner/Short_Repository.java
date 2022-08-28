package com.spring_ui.springuiapp.urlshortner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Short_Repository extends JpaRepository<Short, Integer>{

    Optional<Short> findByShortURL(String shortURL);
    Short findTopByOrderByUrlIdDesc();
    boolean existsByShortURL(String shortURL);
}
