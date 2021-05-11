package com.example.demo.service.interfaces;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.service.interfaces.base.IService;

import java.util.List;

public interface MemberService extends IService<MemberDto, Integer> {

    List<Member> findByAddress(String address);
}
