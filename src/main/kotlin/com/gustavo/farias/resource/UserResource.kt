package com.gustavo.farias.resource

import com.gustavo.farias.model.User
import com.gustavo.farias.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserResource(private val userService: UserService) {

    // Endpoint para obter todos os usuários
    @GetMapping
    fun getAll(): List<User> = userService.findAll()

    // Endpoint para obter um usuário pelo ID
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findById(id)
        return if (user != null) {
            ResponseEntity.ok(user) // Retorna o usuário encontrado
        } else {
            ResponseEntity.notFound().build() // Retorna 404 se não encontrado
        }
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    fun create(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.create(user)
        return ResponseEntity.ok(createdUser) // Retorna o usuário criado
    }

    // Endpoint para atualizar um usuário pelo ID
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        val updatedUser = userService.update(id, user)
        return if (updatedUser != null) {
            ResponseEntity.ok(updatedUser) // Retorna o usuário atualizado
        } else {
            ResponseEntity.notFound().build() // Retorna 404 se não encontrado
        }
    }

    // Endpoint para deletar um usuário pelo ID
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.noContent().build() // Retorna 204 No Content
    }

    // ATUALIZA UM USUÁRIO PARCIALMENTE PELO ID
    // OU SEJA ATUALIZA APENAS OS CAMPOS QUE FOREM ENVIADOS NO REQUEST
    // EXEMPLO: SE O USUÁRIO ENVIAR APENAS O NOME, O ID NÃO SERÁ ALTERADO
    @PatchMapping("/{id}")
    fun partialUpdate(
        @PathVariable id: Long,
        @RequestBody user: User
    ): ResponseEntity<User> {
        val updatedUser = userService.update(id, user)
        return if (updatedUser != null) {
            ResponseEntity.ok(updatedUser) // Retorna o usuário atualizado
        } else {
            ResponseEntity.notFound().build() // Retorna 404 se não encontrado
        }
    }

}
