package com.supportportal.services;

import com.supportportal.dtos.BadgeDto;
import com.supportportal.entities.Badge;
import com.supportportal.entities.Demande;
import com.supportportal.mappers.BadgeMapper;
import com.supportportal.repositories.BadgeDAO;
import com.supportportal.repositories.DemandeDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.Date;


@NoArgsConstructor
@Data
@Service
@Transactional
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeDAO badgeDAO;
    @Autowired
    private BadgeMapper badgeMapper;
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private DemandeDAO demandeDAO ;
    @Override
    public Badge saveBadge(Long id) {
        System.out.println(id);
        Demande demande = demandeDAO.findById(id).orElseThrow(()->new RuntimeException(String.format("Demande not found")));
        Badge badge = new Badge();
        badge.setBadgeType(demande.getBadgeType());
        badge.setANP(demande.getANP());
        badge.setSOMAPORT(demande.getSOMAPORT());
        badge.setMARSAMAROC(demande.getMARSAMAROC());
        badge.setPORTNET(demande.getPORTNET());
        badge.setMASSCEREALES(demande.getMASSCEREALES());
        badge.setONCF(demande.getONCF());
        badge.setOCP(demande.getOCP());
        badge.setTC3(demande.getTC3());
        badge.setPROTECTIONCIVIL(demande.getPROTECTIONCIVIL());
        badge.setMOULAYYOUSSEF(demande.getMOULAYYOUSSEF());
        badge.setCHANTIERNAVAL(demande.getCHANTIERNAVAL());
        badge.setDGSN(demande.getDGSN());
        badge.setDemande(demande);
        badge.setDateDebut(new Date());
        badge.setDateFin(new Date());
        System.out.println(badge);
         return badgeDAO.save(badge);




//        Badge badge = badgeMapper.fromBadgeDto( badgeDto);
//        Badge savedBadge = badgeDAO.save(badge);
//        return badgeMapper.fromBadge(savedBadge);
    }

    @Override
    public BadgeDto getBadge(Long id) {
        Badge badge = badgeDAO.findById(id).orElse(null);
        return badgeMapper.fromBadge( badge);
    }

//    @Override
//    public CurrentBankAccountDto saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
//        Customer customer = cutomerRepository.findById(customerId).orElse(null);
//        if(customer ==null)
//            throw  new CustomerNotFoundException("Customer not found ");
//        CurrentAccount currentAccount = new CurrentAccount() ;
//        currentAccount.setId(UUID.randomUUID().toString());
//        currentAccount.setCreatedAt(new Date());
//        currentAccount.setBalance(initialBalance);
//        currentAccount.setOverDart(overDraft);
//        currentAccount.setCustomer(customer);
//        CurrentAccount savedBankAccount  = bankAccountRepository.save(currentAccount);
//        return bankAccountMapper.fromCurrentBankAccount(savedBankAccount);
//    }
}
