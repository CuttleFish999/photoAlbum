package com.photoalbum.dodo.service;

import com.photoalbum.dodo.model.Members;

public interface MembersFrontEndService {

    Members findIdByAccountAndPassword(Members member);
    Members findMemberById(Integer memberId);
    Members createAnAccount(Members MemberId);
}
