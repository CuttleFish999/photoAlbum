package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.dao.MembersRepository;
import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public Page<Members> getAllMemberPaged(Pageable pageable) {
        return null;
    }
}
