package com.amenbank.bilan_ocr.service;

import com.amenbank.bilan_ocr.dto.BilanDocumentDto;
import com.amenbank.bilan_ocr.entity.Bilan;
import com.amenbank.bilan_ocr.exception.NotFoundException;
import com.amenbank.bilan_ocr.repository.BilanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class BilanService implements IBilanService {
    private final BilanRepository bilanRepository;
    @Autowired
    public BilanService(BilanRepository bilanRepository) {
        this.bilanRepository = bilanRepository;
    }

    @Override
    public Page<Bilan> findAll(Pageable page) {
        return bilanRepository.findAll(page);
    }

    @Override
    public Bilan findByMatricule(String matricule) {
        return bilanRepository.findById(matricule)
                .orElseThrow(() -> new NotFoundException("Bilan with matricule " + matricule + " not found"));
    }

    @Override
    public Bilan save(BilanDocumentDto bilanInfo) throws JsonProcessingException {
        var jsonResult = extractBilanValues(bilanInfo.getDocument().getResource());
        Map<String, Double> jsonBilan = new ObjectMapper().readValue(jsonResult, HashMap.class);

        var bilan = new Bilan(jsonBilan);
        bilan.setMatricule(bilanInfo.getMatricule());
        bilan.setRs(bilanInfo.getRs());
        bilan.setYear(bilanInfo.getYear());
        bilan.setEtat(bilanInfo.getEtat());
        bilan.setCreatedAt(new Date());

        return bilanRepository.save(bilan);
    }

    @Override
    public Bilan update(Bilan bilan) {
        return bilanRepository.save(bilan);
    }

    @Override
    public void deleteByMatricule(String matricule) {
        bilanRepository.deleteById(matricule);
    }

    private String extractBilanValues(Resource document) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        var body = new LinkedMultiValueMap<>();
        body.add("file", document);

        var requestEntity = new HttpEntity<>(body, headers);
        var url = "http://localhost:5000/uploadFile";
        var restTemplate = new RestTemplate();
        var response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response.getBody();
    }
}
