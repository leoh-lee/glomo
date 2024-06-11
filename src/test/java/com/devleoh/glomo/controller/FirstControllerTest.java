package com.devleoh.glomo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.devleoh.glomo.controller
 * fileName       : FirstControllerTest
 * author         : nimoh
 * date           : 2024/06/11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/11        nimoh       최초 생성
 */
@SpringBootTest
public class FirstControllerTest {

    @Autowired
    private FirstController firstController;

    @Test
    void test1() {
        Assertions.assertThat(firstController.test()).isEqualTo("abC");
    }
}