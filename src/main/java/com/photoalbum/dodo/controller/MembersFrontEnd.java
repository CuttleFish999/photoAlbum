package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.model.Photos;
import com.photoalbum.dodo.service.Impl.MembersFrontEndServiceImpl;
import com.photoalbum.dodo.service.Impl.PhotosFrontEndServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("")
public class MembersFrontEnd {
    @Autowired
    private MembersFrontEndServiceImpl MembersFrontEndServiceImpl;

    @Autowired
    private PhotosFrontEndServiceImpl photosFrontEndServiceImpl;

    @GetMapping("/test")
    public String test(Model model) {
        return "/frontEnd/viewport/uploadPhoto";
    }


    @GetMapping("/home")
    public String index(Model model) {

//        membersServiceImpl.getAllMembers();

        return "frontEnd/index";
    }

    @GetMapping("/login")
    public String memberLogin() {

        return "frontEnd/login";
    }

    @GetMapping("/register")
    public String memberRegister() {

        return "frontEnd/register";
    }

    //    @ResponseBody
    @PostMapping("/loginAPI")
    public String MemberLogin(@ModelAttribute Members Member,
                              HttpSession session) {
//    public String memberLoginAPI(@RequestBody Members Member){
        System.out.println(Member);
        Members member = MembersFrontEndServiceImpl.findIdByAccountAndPassword(Member);
        System.out.println(member != null);
        if (member != null) {
            session.setAttribute("loggedInMember", member);
            System.out.println("sessionMemId: " + member.getMemberid());
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @ResponseBody
    @PostMapping("/insert/{MemberId}")
    public Members memberRegister(@RequestBody Members Member) {

        Members memeber = MembersFrontEndServiceImpl.createAnAccount(Member);

        return memeber;
    }

//  viewportAPI

    @GetMapping("/viewport")
    public String viewportHome(Model model,
                               HttpSession session) {
        Members member = (Members) session.getAttribute("loggedInMember");
        System.out.println(member);

        List<Photos> photos = photosFrontEndServiceImpl.getAllPhotos(member);

//            System.out.println(photos);

        model.addAttribute("photos", photos);


        return "/frontEnd/viewport/viewindex";
    }

    @ResponseBody
    @PostMapping("/insertPhoto/{MemberId}")
//    public Members insertPhoto(@RequestBody Members Member) {
    public String insertPhotoAPI(@RequestBody Photos photo,
                                 HttpSession session,
                                 Model model) {
        Members loggedInMember = (Members) session.getAttribute("loggedInMember");
        System.out.println(photo.getMemberid());
        photo.setMemberid(loggedInMember.getMemberid());
        System.out.println(photo.getMemberid());
        model.addAttribute(loggedInMember);
        photosFrontEndServiceImpl.InsertPhoto(photo);

//        Members memeber = MembersFrontEndServiceImpl.createAnAccount(Member);

        return "/frontEnd/viewport/viewindex";
    }


}
