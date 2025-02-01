package com.codeit.todoapidesign.service;

import com.codeit.todoapidesign.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoService {

    // Service 측의 요청으로 저장/불러오기

    // TO_DO 항목 작성 및 등록
    Todo saveTodo(Todo todo);

    // TO_DO 항목 업데이트
    Todo updateTodo(Todo todo);

    // TO_DO 항목(제목) 리스트로 불러오기
    List<Todo> getAllTodos();

    // TO_DO 항목 제목 및 상세 내용 조회
    Todo getTodoById(UUID id);

    // TO_DO 항목 삭제
    boolean deleteTodoById(UUID id);

    // 태그
    // List를 통해 반환
    List<Todo> getTodoByTag(String tag);

    // 제목
    // List를 통해 반환
    List<Todo> getTodoByTitle(String title);


}
