package com.beawata.petcare.services;

import com.beawata.petcare.dto.EspecieDTO;
import com.beawata.petcare.entities.Especie;
import com.beawata.petcare.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    //Método GET para listar todas as especies
    @Transactional(readOnly = true)
    public Page<EspecieDTO> findAllPaged(Pageable pageable) {
        Page<Especie> list = especieRepository.findAll(pageable);
        return list.map(x -> new EspecieDTO(x));
    }

    //Método POST para adicionar uma especie
    @Transactional
    public EspecieDTO save(EspecieDTO dto){
        Especie entity = new Especie();
        copyDtoToEntity(dto, entity);
        entity = especieRepository.save(entity);
        return new EspecieDTO(entity);
    }

    public void copyDtoToEntity(EspecieDTO dto, Especie entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }
}
