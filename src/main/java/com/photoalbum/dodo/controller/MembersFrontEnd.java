package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.Impl.MembersFrontEndServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MembersFrontEnd {
    @Autowired
    private MembersFrontEndServiceImpl MembersFrontEndServiceImpl;

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }


    @GetMapping("")
    public String index(Model model) {

//        membersServiceImpl.getAllMembers();

        return "frontEnd/index";
    }

    @GetMapping("/login")
    public String memberLogin() {

        return "frontEnd/login";
    }

//    @ResponseBody
    @PostMapping("/loginAPI")
    public Members MemberLogin(@ModelAttribute Members Member){
//    public String memberLoginAPI(@RequestBody Members Member){
        System.out.println(Member);
        Members member = MembersFrontEndServiceImpl.findIdByAccountAndPassword(Member);

        if (member != null){
            return member;
        }

        return null;

    }


    @ResponseBody
    @PostMapping("/insert/{MemberId}")
    public Members memberRegister(@RequestBody Members Member) {

        Members memeber = MembersFrontEndServiceImpl.createAnAccount(Member);

        return memeber;
    }
}
