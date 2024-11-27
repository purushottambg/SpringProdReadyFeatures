package com.prod_ready_features.prodready.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long postId;
    private String title;
    private String description;

    private LocalDateTime createdAt;  //Auditing Part
    private String createdBy;
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedBy;
}
