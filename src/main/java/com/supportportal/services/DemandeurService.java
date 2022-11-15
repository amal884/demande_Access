package com.supportportal.services;


import com.supportportal.dtos.DemandeurDto;
import com.supportportal.entities.Demande;
import com.supportportal.entities.Demandeur;

import java.util.List;

public interface DemandeurService {
    public List<Demande> getDemandeHistory(String demandeurId);

    List<DemandeurDto> listDemandeurs();

    Demandeur saveDemandeur(Demandeur demandeur);

    DemandeurDto saveDemandeur(DemandeurDto demandeurDto);
//
    DemandeurDto getDemandeur(String cin );

    List<DemandeurDto> searchDemandeur( String searchKeyword);

    void deleteDemandeur(String demid);


//    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size)
//            throws BankAccountNotFoundExcetion;
//
//
//    AccountOperationDTO getOperation(long operationId) throws OperationNotFoundException;


}
