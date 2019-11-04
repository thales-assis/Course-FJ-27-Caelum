package br.com.caelum.course.fj27.resource;

import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.dto.input.TopicSearchInputDTO;
import br.com.caelum.course.fj27.dto.output.TopicBriefOutputDTO;
import br.com.caelum.course.fj27.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/topics")
public class TopicResource {

    @Autowired
    private TopicService topicService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TopicBriefOutputDTO> findAll(TopicSearchInputDTO topicSearchInputDTO,
                                             @PageableDefault(page = 0, size = 24, direction = Direction.DESC) Pageable pageableRequest) {

        Specification<Topic> specification = topicSearchInputDTO.getSpecification();
        Page<Topic> topics = topicService.findAll(specification, pageableRequest);
        Page<TopicBriefOutputDTO> list = TopicBriefOutputDTO.listFromTopics(topics);
        return list;
    }

}