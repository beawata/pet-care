package com.beawata.petcare.services;

import com.beawata.petcare.dto.RotinaDTO;
import com.beawata.petcare.entities.Pet;
import com.beawata.petcare.entities.Rotina;
import com.beawata.petcare.repositories.PetRepository;
import com.beawata.petcare.repositories.RotinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository rotinaRepository;

    @Autowired
    private PetRepository petRepository;

    //Método GET para listar todas as rotinas de um pet
    @Transactional(readOnly = true)
    public Page<RotinaDTO> findByPetIdPaged(Long petId, Pageable pageable) {
        Page<Rotina> list = rotinaRepository.findByPetId(petId, pageable);
        return list.map(x -> new RotinaDTO(x));
    }

    //Método GET para listar todas as rotinas
    @Transactional(readOnly = true)
    public Page<RotinaDTO> findAllPaged(Pageable pageable) {
        Page<Rotina> list = rotinaRepository.findAll(pageable);
        return list.map(x -> new RotinaDTO(x));
    }

    //Método GET para buscar uma rotina pelo id
    @Transactional(readOnly = true)
    public RotinaDTO findById(Long id) {
        Rotina rotina = rotinaRepository.getOne(id);
        return new RotinaDTO(rotina);
    }

    //Método POST para adicionar uma rotina
    @Transactional
    public RotinaDTO save(RotinaDTO dto){
        Rotina entity = new Rotina();
        copyDtoToEntity(dto, entity);
        entity = rotinaRepository.save(entity);
        return new RotinaDTO(entity);
    }

    //Método PUT para atualizar uma rotina
    @Transactional
    public RotinaDTO update(RotinaDTO dto){
        Rotina entity = rotinaRepository.getOne(dto.getId());
        copyDtoToEntity(dto, entity);
        entity = rotinaRepository.save(entity);
        return new RotinaDTO(entity);
    }

    //Método DELETE para deletar uma rotina
    @Transactional
    public void delete(Long id){
        rotinaRepository.deleteById(id);
    }

    private void copyDtoToEntity(RotinaDTO dto, Rotina entity) {
        entity.setAlimentacao(dto.getAlimentacao());
        entity.setData(dto.getData());
        entity.setObservacao(dto.getObservacao());
        entity.setPeso(dto.getPeso());

        Pet pet = petRepository.getOne(dto.getPetId());
        entity.setPet(pet);
    }

}
