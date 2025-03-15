package com.hmall.item.controller;

import com.hmall.item.domain.po.Item;
import com.hmall.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class itemTestController {

    private final ItemMapper itemMapper;

    @GetMapping
    public List<Item> test() {
      List<Item> itemList= itemMapper.getItemS();
      return itemList;
    }
}
