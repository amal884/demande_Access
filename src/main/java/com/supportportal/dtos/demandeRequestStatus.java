package com.supportportal.dtos;

import com.supportportal.entities.DemandeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class demandeRequestStatus {
    private DemandeStatus demandeStatus ;
}
