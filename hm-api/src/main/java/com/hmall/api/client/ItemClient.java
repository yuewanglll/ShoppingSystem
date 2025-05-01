package com.hmall.api.client;

import com.hmall.common.domain.dto.ItemDTO;
import com.hmall.api.config.DefaultFeignConfig;
import com.hmall.api.fallback.ItemClientFallback;
import com.hmall.common.domain.PageDTO;
import com.hmall.common.domain.PageQuery;
import com.hmall.common.domain.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "item-service",
        configuration = DefaultFeignConfig.class,
        fallbackFactory = ItemClientFallback.class)
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);

    @GetMapping("/items/page")
    PageDTO<ItemDTO> queryItemByPage(@RequestBody PageQuery query);

    @GetMapping("/items/{id}")
    ItemDTO queryItemById(@PathVariable("id") Long id);

    @PostMapping("/items")
    void saveItem(@RequestBody ItemDTO item);

    @PutMapping("/items/status/{id}/{status}")
    void updateItemStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status);

    @PutMapping("/items")
    void updateItem(@RequestBody ItemDTO item);

    @DeleteMapping("/items/{id}")
    void deleteItemById(@PathVariable("id") Long id);

    @PutMapping("/items/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);

}
