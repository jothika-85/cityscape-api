package com.cityscape.egovernace.repository;

import com.cityscape.egovernace.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
   
    List<Message> findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(
        String s1, String r1, String s2, String r2
    );
}