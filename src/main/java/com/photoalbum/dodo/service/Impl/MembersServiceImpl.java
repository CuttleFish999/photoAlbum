package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.service.MembersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MembersServiceImpl implements MembersService {
    @Override
    public Members saveMember(Members member) {
        return null;
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
