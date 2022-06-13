package com.adjecti.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.spring.entity.PersonalDetails;


@Repository
public interface PersonalRepository extends JpaRepository<PersonalDetails, Integer> {

}