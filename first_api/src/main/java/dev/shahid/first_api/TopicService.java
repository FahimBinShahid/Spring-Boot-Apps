package dev.shahid.first_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    public List<Topic> topics = new ArrayList<>(
//            Arrays.asList(
//                    new Topic("37", "Spring", "SpringMVC"),
//                    new Topic("38", " Java", "Java master"),
//                    new Topic("39", "javascript", "Node-js, React -js")
//            ));

    public List<Topic> getALlTopic() {
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;

    }

    public Topic getTopicById(int id) {
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(int id, Topic topic){
       topicRepository.save(topic);
        }


    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }
}



