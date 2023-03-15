package com.xxywebsite.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @author xuxiaoyin
 * @since 2023/3/15
 **/
@SpringBootTest
@Slf4j
public class SpringTest {
    @MockBean
    private ApplicationContext applicationContext;

    private Object dummyObject = new Object();

    @BeforeEach
    public void setUp() {
        Mockito.when(applicationContext.getBean(Mockito.any(Class.class))).thenReturn(dummyObject);
    }

    @Test
    public void test() {
        log.info("unit test start");
        Assert.isTrue(Objects.equals(applicationContext.getBean(App.class), dummyObject), "mock failed");
    }
}
