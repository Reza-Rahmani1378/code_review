package com.vasl.code_review.dal.repository;

import com.vasl.code_review.dal.entity.SmsServer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmsServerRepository extends PagingAndSortingRepository<SmsServer, String> {
    Optional<SmsServer> findByActive(Boolean active);
}
