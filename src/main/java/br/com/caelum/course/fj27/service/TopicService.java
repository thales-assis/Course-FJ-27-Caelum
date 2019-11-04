package br.com.caelum.course.fj27.service;

import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

}
