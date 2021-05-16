package com.archsoft.repository;

import com.archsoft.model.order.StockAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockActionRepository extends MongoRepository<StockAction, String> {


}
