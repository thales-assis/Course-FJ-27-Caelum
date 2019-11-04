package br.com.caelum.course.fj27.repository;

import br.com.caelum.course.fj27.domain.Course;
import br.com.caelum.course.fj27.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

//  @Query("SELECT topic FROM Topic topic WHERE topic.course = :course")
    List<Topic> findByCourse(@Param("course") Course course);

    List<Topic> findByCourseName(String courseName);

    List<Topic> findByCourseNameOrderByCreationInstantDesc(String courseName);
}
