package com.cityscape.egovernace.repository;
import com.cityscape.egovernace.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<TenderBid, Long> {
    // Contractor பேரை வச்சு அவங்களோட பிட்ஸ் ஹிஸ்டரியை மட்டும் எடுக்க இந்த மெத்தட் உதவும்
    List<TenderBid> findByContractorName(String contractorName);
}