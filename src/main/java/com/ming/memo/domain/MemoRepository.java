package com.ming.memo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//interface : 클래스에서 멤버변수가 없고 메소드만 있는 거
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
}
