package br.com.caelum.course.fj27.service;

import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Page<Topic> findAll(Specification specification, Pageable pageableRequest) {
        return topicRepository.findAll(specification, pageableRequest);
    }

}
