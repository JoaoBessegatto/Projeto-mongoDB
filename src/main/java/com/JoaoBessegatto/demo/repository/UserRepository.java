package com.JoaoBessegatto.demo.repository;

import com.JoaoBessegatto.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.management.monitor.Monitor;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
