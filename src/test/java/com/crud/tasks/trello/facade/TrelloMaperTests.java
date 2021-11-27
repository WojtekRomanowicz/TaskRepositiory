package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMaperTests {


    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void TrelloMapperMapToCardTestSuite(){
        //Given
        final TrelloCardDto trelloCardDto = new TrelloCardDto("test", "to test", "1", "1");

        //When
         TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);


        //Then
        assertEquals("test", trelloCard.getName());
        assertEquals("to test", trelloCard.getDescription());
        assertEquals("1", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());

    }

    @Test
    void TrelloMapperMapToCardDtoTestSuite(){
        //Given
        final TrelloCard trelloCard = new TrelloCard("test", "to test", "1", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);


        //Then
        assertEquals("test", trelloCardDto.getName());
        assertEquals("to test", trelloCardDto.getDescription());
        assertEquals("1", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());

    }

    @Test
    void TrelloMapperMapToList(){
        //Given
        List<TrelloListDto> listDto = new ArrayList<>();
        final TrelloListDto trelloListDto = new TrelloListDto("1", "test", true);
        listDto.add(trelloListDto);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(listDto);

        //Then
        assertEquals("1",trelloList.get(0).getId());
        assertEquals("test", trelloList.get(0).getName());
        assertEquals(true, trelloList.get(0).isClosed());
    }

    @Test
    void TrelloMapperMapToListDto(){
        //Given
        List<TrelloList> list = new ArrayList<>();
        final TrelloList trelloList = new TrelloList("1", "test", true);
        list.add(trelloList);

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(list);

        //Then
        assertEquals("1",trelloListDto.get(0).getId());
        assertEquals("test", trelloListDto.get(0).getName());
        assertEquals(true, trelloListDto.get(0).isClosed());
    }

    @Test
    void TrelloMapperMapToBoards(){
        //Given
        List<TrelloListDto> listDto = new ArrayList<>();
        final TrelloListDto trelloListDto = new TrelloListDto("1", "test", true);
        listDto.add(trelloListDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
              trelloBoardsDto.add(new TrelloBoardDto("1","test",listDto));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);


        //Then
        assertEquals("1",trelloBoards.get(0).getId());
        assertEquals("test",trelloBoards.get(0).getName());
        assertEquals(1,trelloBoards.get(0).getLists().size());

    }

    @Test
    void TrelloMapperMapToBoardsDto(){
        //Given
        List<TrelloList> list = new ArrayList<>();
        final TrelloList trelloList = new TrelloList("1", "test", true);
        list.add(trelloList);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","test",list));

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);


        //Then
        assertEquals("1",trelloBoardsDto.get(0).getId());
        assertEquals("test",trelloBoardsDto.get(0).getName());
        assertEquals(1,trelloBoardsDto.get(0).getLists().size());

    }

}
