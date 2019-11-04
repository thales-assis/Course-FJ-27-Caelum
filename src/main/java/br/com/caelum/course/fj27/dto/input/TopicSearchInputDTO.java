package br.com.caelum.course.fj27.dto.input;

import br.com.caelum.course.fj27.domain.Topic;
import br.com.caelum.course.fj27.domain.TopicStatus;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TopicSearchInputDTO {

    private TopicStatus status;
    private String categoryName;

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Specification<Topic> getSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            if (categoryName != null) {
                Path<String> categoryNamePath = root.get("course").get("subcategory").get("category").get("name");
                predicates.add((Predicate) criteriaBuilder.equal(categoryNamePath, categoryName));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}