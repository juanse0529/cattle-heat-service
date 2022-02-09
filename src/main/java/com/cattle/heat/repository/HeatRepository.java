package com.cattle.heat.repository;

import com.cattle.commons.model.Heat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatRepository extends CrudRepository<Heat,String> {
}
