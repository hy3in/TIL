package hello.hellospring.domain;

import javax.persistence.*;

//해당 annotation을 사용하면 JPA가 관리하는 entity가 됨
@Entity
public class Member {

    //PK annotation
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //고객이 아닌 시스템이 정하는 아이디

    //@Column(name = "username") : DB Column명이 Username일 경우 아래 변수 name과 매핑해줌
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
