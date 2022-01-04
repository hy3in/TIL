package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//interface가 interface를 받을 때는 implements가 아니라 extends를 사용한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository    {
    @Override
    Optional<Member> findByName(String name);
}
