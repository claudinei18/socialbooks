package com.socialbooks.socialbooks.repository;

import com.socialbooks.socialbooks.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long>{


}
