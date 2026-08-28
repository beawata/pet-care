package com.beawata.petcare.services;

import com.beawata.petcare.dto.EspecieDTO;
import com.beawata.petcare.entities.Especie;
import com.beawata.petcare.repositories.EspecieRepository;
import com.beawata.petcare.services.exceptions.DataBaseException;
import com.beawata.petcare.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    //Método GET para buscar espécie pelo id
    @Transactional(readOnly = true)
    public EspecieDTO findById(Long id) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espécie não encontrada"));
        return new EspecieDTO(especie);
    }

    //Método POST para adicionar uma especie
    @Transactional
    public EspecieDTO save(EspecieDTO dto){
        Especie entity = new Especie();
        copyDtoToEntity(dto, entity);
        entity = especieRepository.save(entity);
        return new EspecieDTO(entity);
    }

    //Método PUT para atualizar uma especie
    @Transactional
    public EspecieDTO update(EspecieDTO dto){
        try {
            Especie entity = especieRepository.findById(dto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Espécie não encontrada"));
            copyDtoToEntity(dto, entity);
            entity = especieRepository.save(entity);
            return new EspecieDTO(entity);
        }
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    //Método DELETE para deletar uma especie
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!especieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            especieRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha na integridade referencial");
        }
    }

    public void copyDtoToEntity(EspecieDTO dto, Especie entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }
}
