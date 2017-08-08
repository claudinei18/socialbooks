package com.socialbooks.socialbooks.repository;

import com.socialbooks.socialbooks.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autor,Long>{
}