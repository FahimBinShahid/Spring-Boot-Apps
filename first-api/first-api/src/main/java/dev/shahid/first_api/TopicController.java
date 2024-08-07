package dev.shahid.first_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic>getAllTopics(){
        return topicService.getALlTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.getTopicById(id);
    }

}
