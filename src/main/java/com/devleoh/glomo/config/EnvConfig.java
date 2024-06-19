package com.devleoh.glomo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * packageName    : com.devleoh.glomo.config.env
 * fileName       : EnvConfig
 * author         : nimoh
 * date           : 2024/05/27
 * description    : env.properties 파일을 스프링 Config에 세팅
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/05/27        nimoh       최초 생성
 */
@Configuration
@PropertySource("classpath:env.properties")
public class EnvConfig {
}
