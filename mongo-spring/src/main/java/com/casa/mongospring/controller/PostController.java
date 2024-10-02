package com.casa.mongospring.controller;

import com.casa.mongospring.controller.util.URL;
import com.casa.mongospring.model.WebPost;
import com.casa.mongospring.service.WebPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final WebPostService webPostService;

    @Autowired
    public PostController(WebPostService webPostService){
        this.webPostService = webPostService;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/post")
    public ResponseEntity<List<WebPost>> getUser() {
        List<WebPost> posts = webPostService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/post/{id}")
    public ResponseEntity<WebPost> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(webPostService.findPostById(id));
    }

    @RequestMapping(method=RequestMethod.POST, value = "/post")
    public ResponseEntity<WebPost> createUser(@RequestBody WebPost post) {
        return ResponseEntity.created(
                org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(post.getId()).toUri()
        ).body(webPostService.createPost(post));
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/post/{id}")
    public ResponseEntity<Void> deleteWebPost(@PathVariable String id) {
        webPostService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/titlesearch")
    public ResponseEntity<List<WebPost>> getAllPosts(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decode(text);
        return ResponseEntity.ok(webPostService.findPostsByTitleContaining(text));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullsearch")
    public ResponseEntity<List<WebPost>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                             @RequestParam(value = "from", defaultValue = "") String from,
                             @RequestParam(value = "to", defaultValue = "") String to) {

        Date dateFrom = URL.convertDate(from, new Date());
        Date dateTo = URL.convertDate(to, new Date());

        return ResponseEntity.ok(webPostService.fullSearch(text, dateFrom, dateTo));
    }
}
