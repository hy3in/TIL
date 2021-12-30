package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //여러개 생성 할 필요가 없음 하나로 돌려 쓰면됨 => Spring Container에 등록해서 사용한다.
//    private final MemberService memberService;

    //Field Injection - 나중에 바꿀 수 있는 방법이 없으므로 잘 사용하지 않는다.
//    @Autowired private MemberService memberService;

    //Setter Injection - memberController를 호출할 때 해당 메소드가 public으로 열려있어야 하므로 보안상의 문제가 된다.
    /*@Autowired
    public void setMemberService(MemberService memberService){
        this.MemberService() = memberService;
    }*/


    //Constructor Injection - 권장
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
