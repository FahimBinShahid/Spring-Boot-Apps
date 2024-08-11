package course;

import dev.shahid.first_api.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

   @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/course")
    public List<Course>getAllCourses(@PathVariable int id){
        return courseService.getALlCourse(id);
    }

    @RequestMapping("/topics/{topicId}/course/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
    public void addCourse(@RequestBody Course course){
        int topicId = 0;
        course.setTopic(new Topic(topicId, " ", " "));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id){
        course.setTopic(new Topic(topicId, " ", " "));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(getCourseById(id));
    }

}
