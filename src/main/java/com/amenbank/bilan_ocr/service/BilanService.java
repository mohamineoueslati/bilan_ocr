package com.amenbank.bilan_ocr.service;

import com.amenbank.bilan_ocr.dto.BilanDocumentDto;
import com.amenbank.bilan_ocr.entity.Bilan;
import com.amenbank.bilan_ocr.exception.NotFoundException;
import com.amenbank.bilan_ocr.repository.BilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BilanService implements IBilanService {
    private final BilanRepository bilanRepository;

    @Autowired
    public BilanService(BilanRepository bilanRepository) {
        this.bilanRepository = bilanRepository;
    }

    @Override
    public List<Bilan> findAll() {
        return bilanRepository.findAll();
    }

    @Override
    public Bilan findByMatricule(String matricule) {
        return bilanRepository.findById(matricule)
                .orElseThrow(() -> new NotFoundException("Bilan with matricule " + matricule + " not found"));
    }

    @Override
    public Bilan save(BilanDocumentDto bilanInfo) {
        return null;
    }

    @Override
    public Bilan update(Bilan bilan) {
        return bilanRepository.save(bilan);
    }

    @Override
    public void deleteByMatricule(String matricule) {
        bilanRepository.deleteById(matricule);
    }
}
