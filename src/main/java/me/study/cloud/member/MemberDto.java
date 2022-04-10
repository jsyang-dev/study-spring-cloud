package me.study.cloud.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
public class MemberDto implements Serializable {

    private final Long id;
    private final String name;
    private final int age;
    private final LocalDateTime created;

    @Builder
    private MemberDto(Long id, String name, int age, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.created = created;
    }
}
