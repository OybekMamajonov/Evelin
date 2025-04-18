package com.example.evelin.repository;

import com.example.evelin.model.Attach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachRepo extends JpaRepository<Attach,Integer> {
//    boolean existsByOrigin_name(String origin_name);
}
