package com.cityscape.egovernace.controller;

import com.cityscape.egovernace.model.*;
import com.cityscape.egovernace.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://cityscape-ui.vercel.app") 
@RestController
@RequestMapping("/api/bids") 
public class TenderController {

    @Autowired
    private BidRepository bidRepository;

    
    @PostMapping("/apply")
    public TenderBid applyForTender(@RequestBody TenderBid newBid) {
        return bidRepository.save(newBid);
    }

    
    @SuppressWarnings("unused")
	@GetMapping("/all")
    public List<TenderBid> getAllBids() {
        return bidRepository.findAll();
    }
}


