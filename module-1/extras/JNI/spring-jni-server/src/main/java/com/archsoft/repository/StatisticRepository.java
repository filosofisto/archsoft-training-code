package com.archsoft.repository;

import com.archsoft.model.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {

    List<Statistic> findAll();
}
