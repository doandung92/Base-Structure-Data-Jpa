package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Address_;
import com.example.demo.entity.Member;
import com.example.demo.entity.Member_;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.interfaces.base.BaseService;
import com.example.demo.service.interfaces.MemberService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends BaseService<Member, MemberDto, Integer, MemberRepository>
        implements MemberService {

    public MemberServiceImpl(MemberRepository repository,
                             MapperFacade mapper) {
        super(Member.class, MemberDto.class, repository, mapper);
    }

    @Override
    public List<Member> findByAddress(String address) {
        return super.getRepository().findAll(getQueryForEqual(address, Member_.ADDRESS, Address_.ADDRESS));
    }
}
