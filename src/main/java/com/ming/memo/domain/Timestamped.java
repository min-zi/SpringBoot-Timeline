package com.ming.memo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 이 클래스를 상속받은 Memo Entity가 자동으로 컬럼으로 인식할 수 있도록 해 줌
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트함
public abstract class Timestamped { //abstract : 상속이 된 자식클래스만 new로 객체 생성이 가능

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}