package org.parovsky.controller;

import lombok.RequiredArgsConstructor;
import org.parovsky.dto.OrderRequest;
import org.parovsky.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order Placed Successfully";
	}
}
