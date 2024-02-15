package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.service.Impl.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MembersFrontEnd {
    @Autowired
    private MembersServiceImpl membersServiceImpl;

    @GetMapping("")
    public String index(Model model){

//        membersServiceImpl.getAllMembers();

        return "index";
    }
}
