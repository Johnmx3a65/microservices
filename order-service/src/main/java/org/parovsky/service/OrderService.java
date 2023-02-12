package org.parovsky.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.parovsky.dto.OrderLineItemsDTO;
import org.parovsky.dto.OrderRequest;
import org.parovsky.model.Order;
import org.parovsky.model.OrderLineItems;
import org.parovsky.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());

		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());

		order.setOrderLineItemsList(orderLineItems);

		orderRepository.save(order);
		log.info("Order {} is saved", order.getId());
	}

	private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDTO.getPrice());
		orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
		return orderLineItems;
	}
}
