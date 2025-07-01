package com.gustavo.farias.service

import com.gustavo.farias.model.User
import com.gustavo.farias.repository.UserRepository
import org.springframework.stereotype.Service

// ANOTAÇÃO PARA DIZER QUE É UM SERVIÇO
// USADO PARA REALIZAR A LÓGICA DE NEGÓCIO DA APLICAÇÃO
@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun create(user: User): User = userRepository.save(user)

    // ATUALIZA UM USUÁRIO PELO ID
    fun update(id: Long, user: User): User? {
        // retorna o usuário atualizado se o ID existir no banco de dados
        return if (userRepository.existsById(id)) {
            // salva o usuário com o ID atualizado
            userRepository.save(user.copy(id = id))
        } else { // se não é nulo
            null
        }
    }

    // DELETA UM USUÁRIO PELO ID
    fun delete(id: Long) {
        // SE O USUÁRIO EXISTIR, DELETA O USUÁRIO
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        }
    }
}