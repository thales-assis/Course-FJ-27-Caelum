package br.com.caelum.course.fj27.dto.output;

import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.domain.TopicStatus;
import org.springframework.data.domain.Page;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TopicBriefOutputDTO {

    private Long id;
    private String shortDescription;
    private long secondsSinceLastUpdate;
    private String ownerName;
    private String courseName;
    private String subcategoryName;
    private String categoryName;
    private int numberOfResponses;
    private boolean solved;

    public TopicBriefOutputDTO(Topic topic) {
        this.id = topic.getId();
        this.shortDescription = topic.getShortDescription();
        this.secondsSinceLastUpdate = getSecondsSince(topic.getLastUpdate());
        this.ownerName = topic.getOwner().getName();
        this.courseName = topic.getCourse().getName();
        this.subcategoryName = topic.getCourse().getSubcategoryName();
        this.categoryName = topic.getCourse().getCategoryName();
        this.numberOfResponses = topic.getNumberOfAnswers();
        this.solved = TopicStatus.SOLVED.equals(topic.getStatus());
    }

    private long getSecondsSince(Instant lastUpdate) {
        return Duration.between(lastUpdate, Instant.now()).get(ChronoUnit.SECONDS);
    }

    public Long getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public long getSecondsSinceLastUpdate() {
        return secondsSinceLastUpdate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getNumberOfResponses() {
        return numberOfResponses;
    }

    public boolean isSolved() {
        return solved;
    }

    public static Page<TopicBriefOutputDTO> listFromTopics(Page<Topic> topics) {
        return topics.map(TopicBriefOutputDTO::new);
    }
}
