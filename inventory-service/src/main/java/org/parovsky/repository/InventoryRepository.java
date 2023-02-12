package org.parovsky.repository;

import org.parovsky.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	boolean existsBySkuCode(String skuCode);
}
