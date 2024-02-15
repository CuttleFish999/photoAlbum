package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.Impl.MembersFrontEndServiceImpl;
import com.photoalbum.dodo.service.Impl.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MembersFrontEnd {
    @Autowired
    private MembersFrontEndServiceImpl MembersFrontEndServiceImpl;

    @GetMapping("")
    public String index(Model model){

//        membersServiceImpl.getAllMembers();

        return "index";
    }

    @ResponseBody
    @PostMapping("/insert/{MemberId}")
    public Members insertPhoto(@RequestBody Members MemberId){

        System.out.println(MemberId);
        Members memeber = MembersFrontEndServiceImpl.findMembersById(MemberId.getMemberid());

        return memeber;
    }
}
