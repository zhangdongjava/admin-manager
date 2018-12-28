package com.jwl.common.sys.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JavaBeanConfig {



    @Bean
    @LoadBalanced//负载均注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 负载均衡方式
     * @return
     */
    @Bean
    public IRule route(){
        //netfi
        return new RandomRule();
    }


    @Bean
    public SpringDataUserDetailsService userDetailsService() {
        return new SpringDataUserDetailsService();
    }
//    @Bean
//    public MyAuthenticationProvider myAuthenticationProvider() {
//        return new MyAuthenticationProvider();
//    }
}
