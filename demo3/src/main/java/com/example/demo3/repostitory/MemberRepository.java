package com.example.demo3.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> { //<테이블 참조, 기본값의 유형>

}
