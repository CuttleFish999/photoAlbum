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
    public Members findMembersById(Integer MmeberId) {

        Optional<Members> Member = membersFrontEndRepository.findById(MmeberId);

        return Member.orElse(null);
    }
}
