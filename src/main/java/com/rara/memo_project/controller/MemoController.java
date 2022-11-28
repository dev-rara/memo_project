package com.rara.memo_project.controller;

import com.rara.memo_project.dto.MemoRequestDto;
import com.rara.memo_project.entity.Memo;
import com.rara.memo_project.service.MemoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class MemoController {
	private final MemoService memoService;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@PostMapping("/api/memos")
	public Memo createMemo(@RequestBody MemoRequestDto requestDto) {

		return memoService.createMemo(requestDto);
	}

	@GetMapping("/api/memos")
	public List<Memo> getMemos() {
		return memoService.getMemos();
	}

	@PutMapping("/api/memos/{id}")
	public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
		return memoService.update(id, requestDto);
	}

	@DeleteMapping("/api/memos/{id}")
	public Long deleteMemo(@PathVariable Long id) {
		return memoService.deleteMemo(id);
	}

}
