package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskController taskController;

//    @Test
//    void shouldGetTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "test", "test task");
//        when(taskController.getTask(1L)).thenReturn(taskDto);
//
//        //When & Then
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/v1/task/getTask")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1L)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("test")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("test task")));
//    }

}