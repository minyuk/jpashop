package jpabook.jpashop.service.query;

import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public List<OrderDTO> ordersV3() {
        return orderRepository.findAllWithItem().stream()
                .map(OrderDTO::new).collect(Collectors.toList());
    }

}
