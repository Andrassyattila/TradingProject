package com.codecool.tradingproject.controller;


import com.codecool.tradingproject.model.Conversation;
import com.codecool.tradingproject.model.Message;
import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.ConversationRepository;
import com.codecool.tradingproject.repository.MessageRepository;
import com.codecool.tradingproject.repository.UsersRepository;
import com.codecool.tradingproject.service.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@AllArgsConstructor
@Controller
public class MessageController {
    ConversationRepository conversationRepository;
    UsersRepository usersRepository;
    MessageRepository messageRepository;
    UserServiceImplementation usi;

    @GetMapping("/messages")
    public String getSendMessageForm(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users user = usi.findByUsername(authentication.getName());
        List<Conversation> conversations = conversationRepository.findAllConversationForUser(user.getId());
        model.addAttribute("conversations",conversations);
        model.addAttribute("userid",user.getId());
        return "messages";
    }

    @PostMapping("/newmessage/{userA}/{userB}")
    public String newMessage(@PathVariable(value="userA")String userAId,@PathVariable(value = "userB")String userBId){
        Long userA=Long.parseLong(userAId);
        Long userB=Long.parseLong(userBId);
        if(conversationRepository.findConversationByUsersId(userA, userB) == null){
            Conversation conversation=new Conversation();
            conversation.setUserA(usersRepository.getById(userA));
            conversation.setUserB(usersRepository.getById(userB));
            conversationRepository.save(conversation);
        }else{
            System.out.println(conversationRepository.findConversationByUsersId(userA,userB));
        }

        return "redirect:/sendmessage/"+userA+"/"+userB;
    }
    @GetMapping("/sendmessage/{userA}/{userB}")
    public String getMessageForm(@PathVariable(value="userA")String userAId, @PathVariable(value = "userB")String userBId, Model model){
        Long userA=Long.parseLong(userAId);
        Long userB=Long.parseLong(userBId);
        Conversation c =conversationRepository.findConversationByUsersId(userA, userB);
        List<Message> messages =messageRepository.findAllByConversationOrderByMessageSentAsc(c);
        model.addAttribute("messages",messages);
        model.addAttribute("messageobj",new Message());
        model.addAttribute("userA",userA);
        model.addAttribute("userB",userB);

        return "messageform";
    }

    @PostMapping("/sendmessage/{userA}/{userB}")
    public String sendMessage(@ModelAttribute Message message,@PathVariable(value="userA")String userAId, @PathVariable(value = "userB")String userBId){
        Long userA=Long.parseLong(userAId);
        Long userB=Long.parseLong(userBId);
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users user = usi.findByUsername(authentication.getName());
        message.setAuthor(user);
        message.setConversation(conversationRepository.findConversationByUsersId(userA, userB));
        messageRepository.save(message);
        return"redirect:/sendmessage/"+userA+"/"+userB;
    }



}
