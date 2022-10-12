package com.vasl.code_review.dal.repository;

import com.vasl.code_review.dal.entity.MailServer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailServerRepository extends PagingAndSortingRepository<MailServer , String> {

    Optional<MailServer> findByActive(Boolean active);
}
