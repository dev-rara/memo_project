package com.rara.memo_project.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {    //client 에서 넘어오는 username, contents를 받아준다
	private String username;
	private String contents;
}
