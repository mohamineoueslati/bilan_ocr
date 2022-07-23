package com.amenbank.bilan_ocr.controller;

import com.amenbank.bilan_ocr.dto.BilanDocumentDto;
import com.amenbank.bilan_ocr.dto.BilanDto;
import com.amenbank.bilan_ocr.dto.BilanResponse;
import com.amenbank.bilan_ocr.entity.Bilan;
import com.amenbank.bilan_ocr.service.IBilanService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bilans")
public class BilanController {
    private final IBilanService bilanService;
    private final ModelMapper modelMapper;

    public BilanController(IBilanService bilanService, ModelMapper modelMapper) {
        this.bilanService = bilanService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BilanResponse> getBilans() {
        var bilans = bilanService.findAll();

        return bilans.stream()
                .map(bilan -> modelMapper.map(bilan, BilanResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{matricule}")
    public BilanResponse getBilan(@PathVariable String matricule) {
        var bilan = bilanService.findByMatricule(matricule);

        return modelMapper.map(bilan, BilanResponse.class);
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public BilanResponse uploadBilan(@ModelAttribute BilanDocumentDto bilanInfo) {
        var bilan = bilanService.save(bilanInfo);

        return modelMapper.map(bilan, BilanResponse.class);
    }

    @PutMapping("{matricule}")
    public BilanResponse updateBilan(@PathVariable String matricule, @RequestBody BilanDto bilanRequest) {
        bilanRequest.setMatricule(matricule);
        var bilan = modelMapper.map(bilanRequest, Bilan.class);
        var bilanRes =  bilanService.update(bilan);

        return modelMapper.map(bilanRes, BilanResponse.class);
    }

    @DeleteMapping("{matricule}")
    public void deleteBilan(@PathVariable String matricule) {
        bilanService.deleteByMatricule(matricule);
    }
}
