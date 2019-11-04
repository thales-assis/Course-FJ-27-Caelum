package br.com.caelum.course.fj27.resource;

import br.com.caelum.course.fj27.domain.Category;
import br.com.caelum.course.fj27.domain.Course;
import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/topics")
public class TopicResource {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Topic> findAll() {

        Category subcategory = new Category("Java", new Category("Programação"));
        Course course = new Course("Java e JSF", subcategory);
        
        Topic topic = new Topic("Problemas com o JSF",
                                "Erro ao fazer conversão da data",
                                new User("Fulano", "fulano@gmail.com", "123456"), 
                                course);

        Topic topic2 = new Topic("Problemas com o JSF",
                                 "Erro ao fazer conversão da data",
                                 new User("Fulano", "fulano@gmail.com", "123456"), 
                                 course);

        List<Topic> list = List.of(topic, topic2);

        return list;
    }

}