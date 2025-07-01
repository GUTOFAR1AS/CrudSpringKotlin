package com.gustavo.farias.repository

import com.gustavo.farias.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// REPOSITÓRIO PARA GERENCIAR ENTIDADES DO TIPO User
// SERVE PARA REALIZAR CONSULTAS NO BANCO DE DADOS
// EXTENDE A INTERFACE JpaRepository, QUE JÁ CONTÉM VÁRIOS MÉTODOS PRONTOS PARA USO
// COMO FIND, SAVE, DELETE, ETC.
@Repository
interface UserRepository : JpaRepository<User, Long>