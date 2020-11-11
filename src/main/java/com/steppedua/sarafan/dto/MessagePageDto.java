package com.steppedua.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.steppedua.sarafan.domain.Message;
import com.steppedua.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}