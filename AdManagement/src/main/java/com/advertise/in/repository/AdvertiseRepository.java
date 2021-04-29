package com.advertise.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advertise.in.model.Advertise;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer> {



}
