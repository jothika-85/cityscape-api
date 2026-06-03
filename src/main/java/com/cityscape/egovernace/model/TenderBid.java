package com.cityscape.egovernace.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tender_bids")
public class TenderBid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectId;
    private String contractorName;
    private Double bidAmount;
    private String status; // "Applied", "Approved", "Rejected"

    // --- Constructors ---
    public TenderBid() {}

    public TenderBid(String projectId, String contractorName, Double bidAmount, String status) {
        this.projectId = projectId;
        this.contractorName = contractorName;
        this.bidAmount = bidAmount;
        this.status = status;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public String getContractorName() { return contractorName; }
    public void setContractorName(String contractorName) { this.contractorName = contractorName; }

    public Double getBidAmount() { return bidAmount; }
    public void setBidAmount(Double bidAmount) { this.bidAmount = bidAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}