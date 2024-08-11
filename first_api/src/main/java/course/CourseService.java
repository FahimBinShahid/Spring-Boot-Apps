package course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    public List<Topic> topics = new ArrayList<>(
//            Arrays.asList(
//                    new Topic("37", "Spring", "SpringMVC"),
//                    new Topic("38", " Java", "Java master"),
//                    new Topic("39", "javascript", "Node-js, React -js")
//            ));

    public List<Course> getALlCourse(int topicId) {
//        return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;

    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();

    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(int id, Course course){
       courseRepository.save(course);
        }


    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }
}



