package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.dao.MembersRepository;
import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersServiceImpl implements MembersService {

    @Autowired
    private MembersRepository membersRepository;

    @Override
    public Members saveMember(Members member) {
        return membersRepository.save(member);
    }

    @Override
    public List<Members> getAllMembers() {
        return null;
    }

    @Override
    public Members findMemberById(Integer MemberId) {

        return null;
    }

    @Override
    public Members updataMember(Members member) {

        Integer memberId = member.getMemberid();

        System.out.println("memberId: " + memberId);

        Optional<Members> findMember = membersRepository.findById(memberId);

        if(findMember.isPresent()){

            findMember.get().setAccount(member.getAccount());
            findMember.get().setPassword(member.getPassword());
            findMember.get().setName(member.getName());
            findMember.get().setEmail(member.getEmail());
            findMember.get().setBirthday(member.getBirthday());
            findMember.get().setPhonenumber(member.getPhonenumber());
            findMember.get().setOtherphonenumber(member.getOtherphonenumber());
            findMember.get().setHomenumber(member.getHomenumber());
            findMember.get().setGender(member.getGender());
            findMember.get().setAvatar(member.getAvatar());
            findMember.get().setCreatetime(member.getCreatetime());
            findMember.get().setUpdatedtime(member.getUpdatedtime());
            findMember.get().setLastonlinetime(member.getLastonlinetime());

            Members updataOK = membersRepository.save(findMember.get());

            System.out.println("更新成功");
            return updataOK;
        }else{
            Members addDataOK = membersRepository.save(findMember.get());

            System.out.println("新增成功");
            return addDataOK;
        }

    }

    @Override
    public Page<Members> getAllMemberPaged(Pageable pageable) {

        return membersRepository.findAll(pageable);
    }
}
