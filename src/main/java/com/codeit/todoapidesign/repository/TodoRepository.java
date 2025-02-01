package com.codeit.todoapidesign.repository;

import com.codeit.todoapidesign.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoRepository {
    // Service 측의 요청으로 저장/불러오기

    // TO_DO 항목 작성 및 등록
    Todo save(Todo todo);

    // TO_DO 항목 업데이트
    Todo update(Todo todo);

    // TO_DO 항목(제목) 리스트로 불러오기
    List<Todo> getAll();

    // TO_DO 항목 제목 및 상세 내용 조회
    Todo getById(UUID id);

    // TO_DO 항목 삭제
    boolean deleteById(UUID id);
}
