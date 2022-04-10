package me.study.cloud.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("캐시에 저장하고 수정한다.")
    void createAndUpdate() {
        MemberDto memberDto = memberService.find(1L);
        System.out.println("memberDto = " + memberDto);

        MemberDto updatedMemberDto = memberService.update(memberDto.getId());
        System.out.println("updatedMemberDto = " + updatedMemberDto);
    }
}
