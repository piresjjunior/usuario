package com.nascimentojamir.usuario.infrastucture.repository;

import com.nascimentojamir.usuario.infrastucture.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
