package com.vineeth.jwtauthentication.repository;

import com.vineeth.jwtauthentication.model.BidderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingRepository extends JpaRepository<BidderModel,Integer> {
}
