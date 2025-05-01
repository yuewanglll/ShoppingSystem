package com.hmall.api.fallback;

import com.hmall.api.client.ItemClient;

import com.hmall.common.domain.PageDTO;
import com.hmall.common.domain.PageQuery;
import com.hmall.common.domain.dto.ItemDTO;
import com.hmall.common.domain.dto.OrderDetailDTO;
import com.hmall.common.utils.CollUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.List;

@Slf4j
public class ItemClientFallback implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("远程调用ItemClient#queryItemByIds方法出现异常，参数：{}", ids, cause);
                // 查询购物车允许失败，查询失败，返回空集合
                return CollUtils.emptyList();
            }

            @Override
            public PageDTO<ItemDTO> queryItemByPage(PageQuery query) {
                return null;
            }

            @Override
            public ItemDTO queryItemById(Long id) {
                return null;
            }

            @Override
            public void saveItem(ItemDTO item) {

            }

            @Override
            public void updateItemStatus(Long id, Integer status) {

            }

            @Override
            public void updateItem(ItemDTO item) {

            }

            @Override
            public void deleteItemById(Long id) {

            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {

            }
        };
    }
}