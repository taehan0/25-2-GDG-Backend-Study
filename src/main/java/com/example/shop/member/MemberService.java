package com.example.shop.member;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long createMember(MemberCreateRequest request) {
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if (existingMember != null) {
            throw new RuntimeException("Member already exists" + request.getLoginId());
        }
        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional(readOnly = true)
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("Member not exists" + id);
        }
        return member;
    }

    public void updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("Member not exists" + id);
        }
        member.updateInfo(request.getPassword(), request.getPhoneNumber(), request.getAddress());
    }

    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("Member not exists" + id);
        }
        memberRepository.deleteById(id);
    }
}
