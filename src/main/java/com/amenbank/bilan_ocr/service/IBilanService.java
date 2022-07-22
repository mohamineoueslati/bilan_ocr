package com.amenbank.bilan_ocr.service;

import com.amenbank.bilan_ocr.dto.BilanUploadDto;
import com.amenbank.bilan_ocr.entity.Bilan;

import java.util.List;

public interface IBilanService {
    List<Bilan> findAll();
    Bilan findByMatricule(String matricule);
    Bilan save(BilanUploadDto bilanInfo);
    Bilan update(Bilan bilan);
    void deleteByMatricule(String matricule);
}
