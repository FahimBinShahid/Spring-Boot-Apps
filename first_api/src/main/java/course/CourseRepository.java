package course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
    
    public List<Course> findByTopicId(int topicId);
//    public List<Course> findByDescription(String Description);


}
