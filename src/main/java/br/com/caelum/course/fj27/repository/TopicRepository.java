package br.com.caelum.course.fj27.repository;

import br.com.caelum.course.fj27.domain.Course;
import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.domain.TopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>, JpaSpecificationExecutor<Topic> {

//  @Query("SELECT topic FROM Topic topic WHERE topic.course = :course")
    List<Topic> findByCourse(@Param("course") Course course);

    List<Topic> findByCourseName(String courseName);

    List<Topic> findByCourseNameOrderByCreationInstantDesc(String courseName);

    @Query("SELECT topic FROM Topic topic "
            + "WHERE topic.course.subcategory.category.name = :categoryName")
    List<Topic> findByCategoryName(String categoryName);

    @Query("SELECT topic FROM Topic topic "
            + "WHERE topic.status = :topicStatus "
            + "AND topic.course.subcategory.category.name = :categoryName")
    List<Topic> findByStatusAndCategoryName(TopicStatus topicStatus, String categoryName);
}
