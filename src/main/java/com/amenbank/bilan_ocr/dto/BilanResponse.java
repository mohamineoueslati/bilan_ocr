package com.amenbank.bilan_ocr.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BilanResponse extends BilanDto {
    private Date createdAt;
    private String ownerUsername;
}
