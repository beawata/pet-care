package com.beawata.petcare.services;

import com.beawata.petcare.dto.PetDTO;
import com.beawata.petcare.entities.Pet;
import com.beawata.petcare.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<PetDTO> findAll() {
        List<Pet> list = petRepository.findAll();

        //converter lista de pets em uma lista de PetDTO
        return list.stream().map(x -> new PetDTO(x))
                .collect(Collectors.toList());
    }

    //Método GET para listar um pet pelo id
    @Transactional(readOnly = true)
    public PetDTO findById(Long id) {
        Pet pet = petRepository.getOne(id);
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
