package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
 * repository는 단순히 저장소에 넣었다 뺐다 하는 역할
 * service class는 business에 의존적으로 설계
 * */
//@Service
@Transactional //jpa사용을 하려면 항상 필요하다.
public class MemberService {

    private final MemberRepository memberRepository;

    //memoryMemberRepository를 new로 직접적으로 생성하는것이 아닌 스프링 컨테이너에서 찾아서 넣어줌 (DI)
//  @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     */
    public long join(Member member) {
        /*
         * ctrl + alt + v         : return을 자동으로 해줌
         * shift + ctrl + alt + t : refactory this 단축키
         * extract method         : 따로 메소드로 뽑을 수 있음
         * ifPresent              : Optional 메소드. 만약 null이 아니라 값이 있다면
         */
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
