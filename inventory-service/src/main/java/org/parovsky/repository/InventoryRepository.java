package org.parovsky.repository;

import org.parovsky.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	boolean existsBySkuCode(String skuCode);

	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
