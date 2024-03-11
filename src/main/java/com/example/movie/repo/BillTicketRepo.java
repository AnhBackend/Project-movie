package com.example.movie.repo;

import com.example.movie.model.BillTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillTicketRepo extends JpaRepository<BillTicket,Integer> {
}
