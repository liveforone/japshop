package jpabook.japshop.service;

import jpabook.japshop.domain.item.Item;
import jpabook.japshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  //읽기 전용
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional  //저장 save이기 때문에 쓰기 전용
    public void save(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItem() {  //전체 조회
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
