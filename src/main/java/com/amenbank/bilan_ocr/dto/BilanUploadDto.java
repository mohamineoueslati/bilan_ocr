package com.amenbank.bilan_ocr.dto;

import com.amenbank.bilan_ocr.entity.Bilan;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class BilanUploadDto {
    @NotBlank
    private String matricule;
    @NotBlank
    private String rs;
    @Pattern(regexp = "^\\d\\d\\d\\d$")
    private int year;
    @NotBlank
    private Bilan.EtatBilan etat;
    @NotBlank
    private String owner;
    @NotNull
    private MultipartFile document;
}
