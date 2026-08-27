package com.beawata.petcare.services;

import com.beawata.petcare.dto.PetDTO;
import com.beawata.petcare.entities.Pet;
import com.beawata.petcare.repositories.PetRepository;
import com.beawata.petcare.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    //Método GET para listar todos os pets
    @Transactional(readOnly = true)
    public Page<PetDTO> findAllPaged(Pageable pageable) {
        Page<Pet> list = petRepository.findAll(pageable);

        //converter lista de pets em uma lista de PetDTO
        return list.map(x -> new PetDTO(x));
    }

    //Método GET para listar um pet pelo id
    @Transactional(readOnly = true)
    public PetDTO findById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet não encontrado"));
        return new PetDTO(pet);
    }

    //Método POST para salvar um pet
    @Transactional
    public PetDTO save(PetDTO dto) {
        Pet entity = new Pet();
        copyDtoToEntity(dto, entity);
        entity = petRepository.save(entity);
        return new PetDTO(entity);
    }

    //Método PUT para atualizar um pet
    @Transactional
    public PetDTO update(PetDTO dto) {
        Pet entity = petRepository.getOne(dto.getId());
        copyDtoToEntity(dto, entity);
        entity = petRepository.save(entity);
        return new PetDTO(entity);
    }

    //Método DELETE para deletar um pet
    @Transactional
    public void delete(Long id) {
        petRepository.deleteById(id);
    }


    public void copyDtoToEntity(PetDTO dto, Pet entity) {
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setMicrochip(dto.getMicrochip());
        entity.setTipo(dto.getTipo());
    }
}
