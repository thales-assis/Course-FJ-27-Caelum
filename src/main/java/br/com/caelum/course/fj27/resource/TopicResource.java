package br.com.caelum.course.fj27.resource;

import br.com.caelum.course.fj27.domain.Category;
import br.com.caelum.course.fj27.domain.Course;
import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.domain.User;
import br.com.caelum.course.fj27.dto.input.TopicSearchInputDTO;
import br.com.caelum.course.fj27.dto.output.TopicBriefOutputDTO;
import br.com.caelum.course.fj27.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/topics")
public class TopicResource {

    @Autowired
    private TopicService topicService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TopicBriefOutputDTO> findAll(TopicSearchInputDTO topicSearchInputDTO) {
        Specification<Topic> specification = topicSearchInputDTO.getSpecification();
        List<Topic> list = topicService.findAll(specification);
        return TopicBriefOutputDTO.listFromTopics(list);
    }

}