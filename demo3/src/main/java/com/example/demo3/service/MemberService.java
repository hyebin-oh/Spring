package com.example.demo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo3.model.Member;
import com.example.demo3.repostitory.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public void save(Member member) {
		memberRepository.save(member); //상속받은 JpaRepostory에 save가 있음
	}
	
	public List<Member> list() {
		return memberRepository.findAll();
	}

	public Member getOne(Long id) {
		return 	memberRepository.getOne(id);
	}
	
	public Member detail(Long id) {
		return memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다");
				});
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}

}
