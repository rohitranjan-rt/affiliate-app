package com.affiliate.app.repository;

import com.affiliate.app.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

}
