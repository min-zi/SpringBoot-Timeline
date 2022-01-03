package com.ming.memo.controller;

import com.ming.memo.domain.Memo;
import com.ming.memo.domain.MemoRepository;
import com.ming.memo.domain.MemoRequestDto;
import com.ming.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo create(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> read() {
        LocalDateTime start = LocalDateTime.now().minusDays(1); // 어제시간
        LocalDateTime end = LocalDateTime.now(); // 지금시간
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PutMapping("/api/memos/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long delete(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
