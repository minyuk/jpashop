package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int quantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.changeParam(name, price, quantity); //setter를 사용하지 않는 쪽으로 개발!
//        findItem.setName(name);
//        findItem.setPrice(price);
//        findItem.setStockQuantity(quantity);
    }

    public List<Item> findItems() {
        return itemRepository.finAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
