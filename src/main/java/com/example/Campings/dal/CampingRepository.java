package com.example.Campings.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Campings.bo.Camping;

public interface CampingRepository extends JpaRepository<Camping, Long> {}
