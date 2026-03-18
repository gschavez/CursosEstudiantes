package com.trabajo.trabajo.repository;

import com.trabajo.trabajo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatergoriaRepository extends JpaRepository<Categoria, Long> {  //para la entidad Categoria con su id
}

