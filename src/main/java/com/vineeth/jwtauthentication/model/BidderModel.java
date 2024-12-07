package com.vineeth.jwtauthentication.model;

import javax.persistence.*;

@Entity
@Table(name = "bidders")
public class BidderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int biddingId;
    private final String projectName = "Metro Phase V 2024";
    private double bidAmount;
    private double yearsToComplete;
    private String datedOfBidding;
    private String status = "pending";
    private int bidderId;

    public BidderModel(int id, int biddingId, double bidAmount, double yearsToComplete, String datedOfBidding, String status, int bidderId) {
        this.id = id;
        this.biddingId = biddingId;
        this.bidAmount = bidAmount;
        this.yearsToComplete = yearsToComplete;
        this.datedOfBidding = datedOfBidding;
        this.status = status;
        this.bidderId = bidderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(int biddingId) {
        this.biddingId = biddingId;
    }

    public String getProjectName() {
        return projectName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getYearsToComplete() {
        return yearsToComplete;
    }

    public void setYearsToComplete(double yearsToComplete) {
        this.yearsToComplete = yearsToComplete;
    }

    public String getDatedOfBidding() {
        return datedOfBidding;
    }

    public void setDatedOfBidding(String datedOfBidding) {
        this.datedOfBidding = datedOfBidding;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    @Override
    public String toString() {
        return "BidderModel{" +
                "id=" + id +
                ", biddingId=" + biddingId +
                ", projectName='" + projectName + '\'' +
                ", bidAmount=" + bidAmount +
                ", yearsToComplete=" + yearsToComplete +
                ", datedOfBidding='" + datedOfBidding + '\'' +
                ", status='" + status + '\'' +
                ", bidderId=" + bidderId +
                '}';
    }
}
