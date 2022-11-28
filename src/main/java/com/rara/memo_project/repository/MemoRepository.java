package com.rara.memo_project.repository;

import com.rara.memo_project.entity.Memo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
	List<Memo> findAllByOrderByModifiedAtDesc();
}
