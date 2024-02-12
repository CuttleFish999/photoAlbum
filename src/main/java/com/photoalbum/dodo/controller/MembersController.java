package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.Impl.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MembersController {

    @Autowired
    private MembersServiceImpl membersServiceImpl;

    @PostMapping("/insert/{memberId}")
    @ResponseBody
    public Integer insertMember(@RequestBody Members members){

//        Integer memberId = membersServiceImpl.updataMember(members).getMemberid();
        Integer memberId = membersServiceImpl.saveMember(members).getMemberid();

        return memberId;
    }


}
