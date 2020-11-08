package com.steppedua.sarafan.service;

import com.steppedua.sarafan.domain.Comment;
import com.steppedua.sarafan.domain.User;
import com.steppedua.sarafan.domain.Views;
import com.steppedua.sarafan.dto.EventType;
import com.steppedua.sarafan.dto.ObjectType;
import com.steppedua.sarafan.repository.CommentRepository;
import com.steppedua.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepository commentRepository, WsSender wsSender) {
        this.commentRepository = commentRepository;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);

        Comment commentFromDb = commentRepository.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
