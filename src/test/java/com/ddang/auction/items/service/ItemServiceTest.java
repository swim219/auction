package com.ddang.auction.items.service;

import com.ddang.auction.items.domain.Item;
import com.ddang.auction.items.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    void addItem() {
        //given
        Item item = new Item();
        item.setItemName("testItem");
        item.setMemberId("testId");
        item.setAddItemDate(LocalDateTime.now().toString());
        item.setEndItemDate(item.getAddItemDate());
        item.setFirstBidPrice(new BigInteger("10000"));
        item.setNowBidPrice(item.getFirstBidPrice());
        item.setMaxBidPrice(item.getFirstBidPrice());
        item.setWinningBidPrice(item.getFirstBidPrice());

        //when
        Item savedItem = itemService.addItem(item);

        //then
        Item findItem = itemService.findItem(savedItem.getItemId()).get();
        assertThat(item.getItemName()).isEqualTo(findItem.getItemName());
    }

    @Test
    void findItem() {
    }

    @Test
    void findItemList() {
    }
}