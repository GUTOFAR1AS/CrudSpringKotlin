package com.gustavo.farias.model

import jakarta.persistence.*

// ANOTAÇÃO PARA DIZER QUE É UMA ENTIDADE DO JPA
@Entity
// ANOTAÇÃO PARA DIZER QUE É UMA ENTIDADE DO JPA E REFERENICIAR A TABELA USER
// NO BANCO DE DADOS.
@Table(name = "users")
data class User(

    @Id // CHAVE PRIMÁRIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // FAZ O AUTOINCREMENTO

    val id: Long = 0, // campo de ID do usuário, auto-incrementado

    val name : String = "", // nome do usuário
)