package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository{
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); //Optional ==> Java8 신규 추가 기능 null이 반환될 때 optional로 감싸서 반환
    List<Member> findAll();
}