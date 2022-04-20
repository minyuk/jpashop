package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional //테스트에 있으면 rollback true db에 저장되지 않음.
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kang");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
     }

     @Test
     public void 중복_회원_예약() throws Exception {
         //given
         Member member1 = new Member();
         member1.setName("kang");

         Member member2 = new Member();
         member2.setName("kang");

         //when
         memberService.join(member1);

         //then
         assertThrows(IllegalStateException.class, () -> memberService.join(member2)); //MemberService -> IllegalStateException("이미 존재하는 회원입니다.")가 예외가 발생했는지

     }

}