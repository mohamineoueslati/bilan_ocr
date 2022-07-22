package com.amenbank.bilan_ocr.controller;

import com.amenbank.bilan_ocr.dto.BilanUploadDto;
import com.amenbank.bilan_ocr.entity.Bilan;
import com.amenbank.bilan_ocr.service.IBilanService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bilans")
public class BilanController {
    private final IBilanService bilanService;

    public BilanController(IBilanService bilanService) {
        this.bilanService = bilanService;
    }

    @GetMapping
    public List<Bilan> getBilans() {
        return bilanService.findAll();
    }

    @GetMapping("{matricule}")
    public Bilan getBilan(@PathVariable String matricule) {
        return bilanService.findByMatricule(matricule);
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Bilan uploadBilan(@ModelAttribute BilanUploadDto bilanInfo) {
        return bilanService.save(bilanInfo);
    }

    @PutMapping("{matricule}")
    public Bilan updateBilan(@PathVariable String matricule, @RequestBody Bilan bilan) {
        return bilanService.update(bilan);
    }

    @DeleteMapping("{matricule}")
    public void deleteBilan(@PathVariable String matricule) {
        bilanService.deleteByMatricule(matricule);
    }
}
