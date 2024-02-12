package com.photoalbum.dodo.service;

import com.photoalbum.dodo.model.Members;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MembersService {
    Members saveMember(Members member);

    List<Members> getAllMembers();

    Members findMemberById(Integer MemberId);

    Members updataMember(Members member);

    Page<Members> getAllMemberPaged(Pageable pageable);
}
