package com.dgit.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dgit.domain.MessageVO;
import com.dgit.persistence.MessageDAO;
import com.dgit.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

  @Inject
  private MessageDAO messageDAO;

  @Inject
  private PointDAO pointDAO;

  @Override
  @Transactional
  public void addMessage(MessageVO vo) throws Exception {

    messageDAO.create(vo);
    pointDAO.updatePoint(vo.getSender(), 10);
  }

  @Override
  public MessageVO readMessage(String uid, Integer mid) throws Exception {

    messageDAO.updateState(mid);

    pointDAO.updatePoint(uid, 5);

    return messageDAO.readMessage(mid);
  }
}
