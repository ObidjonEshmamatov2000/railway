package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.ticket.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Long > {
}
