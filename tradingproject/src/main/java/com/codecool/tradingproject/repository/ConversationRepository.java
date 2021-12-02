package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
    @Override
    List<Conversation> findAll();

    //Query for find thread id with usera userb
    @Query(value = "select * from Conversation c where c.usera_id=(:userA) and c.userb_id =(:userB) or c.usera_id=(:userB) and c.userb_id =(:userA)",nativeQuery = true)
    Conversation findConversationByUsersId(@Param("userA") Long userA,@Param("userB") Long userB);

    @Query(value = "select * from Conversation c where c.usera_id=(:userA) or c.userb_id=(:userA)",nativeQuery = true)
    List<Conversation> findAllConversationForUser(@Param("userA")Long userA);
}
