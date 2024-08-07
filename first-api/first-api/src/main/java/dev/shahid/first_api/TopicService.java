package dev.shahid.first_api;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    public List<Topic> topics =
            Arrays.asList(
                    new Topic("37", "Spring", "SpringMVC"),
                    new Topic("38", " Java", "Java master"),
                    new Topic("39", "javascript", "Node-js, React -js")
            );

    public List<Topic> getALlTopic() {
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }
}


