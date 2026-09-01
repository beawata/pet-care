package com.beawata.petcare.services;

import com.beawata.petcare.dto.RoleDTO;
import com.beawata.petcare.dto.UserDTO;
import com.beawata.petcare.dto.UserInsertDTO;
import com.beawata.petcare.dto.UserUpdateDTO;
import com.beawata.petcare.entities.Role;
import com.beawata.petcare.entities.User;
import com.beawata.petcare.repositories.RoleRepository;
import com.beawata.petcare.repositories.UserRepository;
import com.beawata.petcare.services.exceptions.DataBaseException;
import com.beawata.petcare.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Método para buscar todos os usuários páginados
    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = userRepository.findAll(pageable);
        return list.map(x -> new UserDTO(x));
    }

    //Método para buscar usuário por id
    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return new UserDTO(user);
    }

    //Método para inserir um novo usuário
    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);

        entity.getRoles().clear();
        Role role = roleRepository.findByAuthority("ROLE_TUTOR");
        entity.getRoles().add(role);

        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    //Método para atualizar um usuário
    @Transactional
    public UserDTO update(Long id, UserUpdateDTO dto) {
        try {
            User entity = userRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = userRepository.save(entity);
            return new UserDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    //Método para deletar um usuário
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        try {
            userRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha na integridade referencial");
        }
    }


    public void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setDataNascimento(dto.getDataNascimento());

        entity.getRoles().clear();
        for (RoleDTO roleDto: dto.getRoles()) {
            Role role = roleRepository.getReferenceById(roleDto.getId());
            entity.getRoles().add(role);
        }
    }
}
