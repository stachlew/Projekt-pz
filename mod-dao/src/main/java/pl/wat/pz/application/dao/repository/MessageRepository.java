package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.compositeKeys.MessageId;
import pl.wat.pz.application.dao.domain.Message;

/**
 * Created by DELL on 2016-11-23.
 */
public interface MessageRepository extends JpaRepository<Message,MessageId> {
}
