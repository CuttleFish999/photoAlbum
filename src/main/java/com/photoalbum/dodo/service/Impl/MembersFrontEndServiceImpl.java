package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.dao.MembersFrontEndRepository;
import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.MembersFrontEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembersFrontEndServiceImpl implements MembersFrontEndService {

    @Autowired
    private MembersFrontEndRepository membersFrontEndRepository;

    @Override
    public Members findMemberById(Integer memberId) {

        Optional<Members> Member = membersFrontEndRepository.findById(memberId);

        if(Member.isPresent()){
            System.out.println("登入成功");
            return Member.get();
        }else{
            System.out.println("查無此帳號!請註冊，跳轉回登入");

        }
        return null;
    }

    @Override
    public Members createAnAccount(Members member) {
//        System.out.println(member.getMemberid());
        Optional<Members> Member = membersFrontEndRepository.findById(member.getMemberid());

        if (Member.isPresent()){
            System.out.println(member.getMemberid() + " 此帳號已經有註冊過了喔!");
        }else{
            membersFrontEndRepository.save(member);
            System.out.println(member.getMemberid() + " 此帳號註冊成功");
        }

        return Member.orElse(null);
    }
}
