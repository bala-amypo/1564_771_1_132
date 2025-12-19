package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MatchRecord;

import java.util.List;

public interface MatchRecordRepository extends JpaRepository<MatchRecord, Long> {
    List<MatchRecord> findByUserA_IdOrUserB_Id(Long userId, Long userIdLong);
}