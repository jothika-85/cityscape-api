package com.cityscape.egovernace.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data // Lombok automatically generates getters/setters

public class Project {

	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String projectId; // e.g., PRJ-101
	    private String title;
	    
	    @Column(columnDefinition = "TEXT")
	    private String description;
	    
	    private Double budgetCr;
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProjectId() {
			return projectId;
		}

		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getBudgetCr() {
			return budgetCr;
		}

		public void setBudgetCr(Double budgetCr) {
			this.budgetCr = budgetCr;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getAssignedContractor() {
			return assignedContractor;
		}

		public void setAssignedContractor(String assignedContractor) {
			this.assignedContractor = assignedContractor;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public String getHistoryLog() {
			return historyLog;
		}

		public void setHistoryLog(String historyLog) {
			this.historyLog = historyLog;
		}

		private String status; // Tender Open, In Progress, Completed
	    
	    private String assignedContractor;
	    private LocalDateTime createdDate;
	    
	    @Column(columnDefinition = "TEXT")
	    private String historyLog;

	    @PrePersist
	    protected void onCreate() {
	        this.createdDate = LocalDateTime.now();
	        if (this.status == null) this.status = "Tender Open";
	        if (this.assignedContractor == null) this.assignedContractor = "None";
	    }
	}

