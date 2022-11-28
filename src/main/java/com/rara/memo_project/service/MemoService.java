package com.rara.memo_project.service;

import com.rara.memo_project.dto.MemoRequestDto;
import com.rara.memo_project.entity.Memo;
import com.rara.memo_project.repository.MemoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
	private final MemoRepository memoRepository;

	@Transactional
	public Memo createMemo(MemoRequestDto requestDto) {
		Memo memo = new Memo(requestDto);
		memoRepository.save(memo);
		return memo;
	}

	@Transactional(readOnly = true)
	public List<Memo> getMemos() {
		return memoRepository.findAllByOrderByModifiedAtDesc();
	}

	@Transactional
	public Long update(Long id, MemoRequestDto requestDto) {
		Memo memo = memoRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
		);
		memo.update(requestDto);

		return memo.getId();
	}

	public Long deleteMemo(Long id) {
		memoRepository.deleteById(id);
		return id;
	}
}
