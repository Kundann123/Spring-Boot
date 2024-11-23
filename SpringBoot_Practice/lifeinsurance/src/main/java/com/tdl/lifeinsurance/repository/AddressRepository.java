package com.tdl.lifeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdl.lifeinsurance.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
}
