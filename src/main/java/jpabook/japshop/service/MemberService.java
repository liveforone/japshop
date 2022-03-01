package jpabook.japshop.service;

import jpabook.japshop.domain.Member;
import jpabook.japshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  //읽기 전용으로 설정하면 부하를 줄일 수 있다.
//전체를 읽기전용으로 설정하고 쓰기에만 그냥 Transactional을 걸어주어서 쓰기만 따로 표시해주었다.
@RequiredArgsConstructor  //final 객체의 생성자를 자동으로 주입해줌!!
public class MemberService {

    private final MemberRepository memberRepository;
    //컴파일 시점에 체크할 수 있게 final로 설정


    //-----회원 가입-----
    /*
    쓰기 전용은 절대로 readOnly = true로 설정하면 안된다. -> 쓰기만 따로 표시
    또한 Transactional은 기본값이 readOnly = false 이다.
    */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);  //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    //------회원 전체 조회------
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {  //단 건 조회
        return memberRepository.findOne(memberId);
    }
}
