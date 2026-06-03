package com.cityscape.egovernace.repository;

import com.cityscape.egovernace.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Rendu perukkum naduvula ulla chat-ah mattum fetch panna
    List<Message> findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(
        String s1, String r1, String s2, String r2
    );
}