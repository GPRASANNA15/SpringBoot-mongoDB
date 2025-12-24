package com.example.demo.Repository;

import com.example.demo.Entity.empEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmpRepository extends CrudRepository<empEntity,String> {
    Optional<empEntity> findById(String id);
}
