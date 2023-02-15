package org.parovsky.controller;

import lombok.RequiredArgsConstructor;
import org.parovsky.dto.InventoryResponse;
import org.parovsky.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping("/inventory/{sku-code}")
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@PathVariable("sku-code") String skuCode) {
		return inventoryService.isInStock(skuCode);
	}

	@GetMapping("/inventory")
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam(name = "sku-code") List<String> skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
