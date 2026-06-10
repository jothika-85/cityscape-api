package com.cityscape.egovernace.repository;
import com.cityscape.egovernace.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<TenderBid, Long> {
    
    List<TenderBid> findByContractorName(String contractorName);
}