package com.kondo.repositories;

import com.kondo.entities.TicketActionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketActionHistoryRepository extends JpaRepository<TicketActionHistory, Long> {

    List<TicketActionHistory> findByTicketId(Long id);
}
