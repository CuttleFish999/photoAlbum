package com.photoalbum.dodo.controller;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.Impl.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private MembersServiceImpl membersServiceImpl;

//  BackStage
    @PostMapping("/insert/{memberId}")
    @ResponseBody
    public Integer insertMember(@RequestBody Members members, @PathVariable Integer memberId) {

        byte[] avatarBytes = members.getAvatar();

        if (avatarBytes != null) {
            members.setAvatar(avatarBytes);
        }

        Integer updatedMemberId = membersServiceImpl.updataMember(members).getMemberid();

        return updatedMemberId;
    }

    @GetMapping("/")
    public String listMembers(Model model,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Members> membersPage = membersServiceImpl.getAllMemberPaged(pageRequest);
        Map<Integer, String> imageMap = new HashMap<>();

            for (Members member : membersPage.getContent()) {
                byte[] imageBytes = member.getAvatar();
                if (imageBytes != null) {
                    String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                    imageMap.put(member.getMemberid(), imageBase64);
                }
            }

            model.addAttribute("membersPage", membersPage);
            model.addAttribute("imageMap", imageMap);

            return "/backStage/index";
        }

    }

