package com.learn.demo.storage.service;

import com.learn.demo.storage.entity.CommonResult;
import com.learn.demo.storage.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 库存库中的库存表 服务类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
public interface StorageService extends IService<Storage> {

    CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
