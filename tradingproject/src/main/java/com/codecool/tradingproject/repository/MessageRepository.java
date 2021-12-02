package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Conversation;
import com.codecool.tradingproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllByConversationOrderByMessageSentAsc(Conversation c);
}
