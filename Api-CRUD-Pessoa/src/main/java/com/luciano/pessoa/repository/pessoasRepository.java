package com.luciano.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.pessoa.domain.pessoas;

@Repository
public interface pessoasRepository extends JpaRepository<pessoas, Integer> {


}

