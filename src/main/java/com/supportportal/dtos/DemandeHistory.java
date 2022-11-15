package com.supportportal.dtos;

import com.supportportal.entities.BadgeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DemandeHistory {
    private String DemandeurId;
    private BadgeType badgeType;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<DemandeDto> demandeDtos;
}
