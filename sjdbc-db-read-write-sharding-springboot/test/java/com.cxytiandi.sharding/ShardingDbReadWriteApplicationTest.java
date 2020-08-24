package com.cxytiandi.sharding;

import com.cxytiandi.sharding.po.LouDong;
import com.cxytiandi.sharding.repository.LouDongRepository;
import com.cxytiandi.sharding.service.LouDongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Spring Boot版 Sharding JDBC 垂直拆分（不同的表在不同的库中）+ 读写分离案例
 * 
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDbReadWriteApplication.class)
public class ShardingDbReadWriteApplicationTest {

    @Autowired
    private LouDongService louDongService;
    @Test
    public void addLouDong() {
        for (long i = 0; i < 10; i++) {
            LouDong louDong = new LouDong();
            louDong.setId(i+"a");
            louDong.setCity("深圳");
            louDong.setRegion("宝安");
            louDong.setName("李四");
            louDong.setLdNum("A");
            louDong.setUnitNum("2");
            louDongService.addLouDong(louDong);
        }
        System.out.println("success");
    }
}
