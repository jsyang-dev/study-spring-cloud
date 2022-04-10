package me.study.cloud.member;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberService {

    @CircuitBreaker(name = "member", fallbackMethod = "fallback")
    @Cacheable(value = "member", key = "#id")
    public MemberDto find(Long id) {
        return MemberDto.builder()
                .id(id)
                .name("created" + id)
                .age(id.intValue() % 100)
                .created(LocalDateTime.now())
                .build();
    }

    @CachePut(value = "member", key = "#id")
    public MemberDto update(Long id) {
        return MemberDto.builder()
                .id(id)
                .name("updated" + id)
                .age(id.intValue() % 100)
                .created(LocalDateTime.now())
                .build();
    }

    private MemberDto fallback(Long id, Exception e) {
        return MemberDto.builder().build();
    }
}
