package giuseppelongo.u5d7.controllers;

import giuseppelongo.u5d7.entities.BlogPost;
import giuseppelongo.u5d7.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//1. GET http://localhost:3000/blogposts
//2. POST http://localhost:3000/blogposts (+ body)
//3. GET  http://localhost:3000/blogposts/{blogpostId}
//4. PUT http://localhost:3000/blogposts/{blogpostId} (+ body)
//5. DELETE http://localhost:3000/blogposts/{blogpostId}
@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    //1
    @GetMapping
    List<BlogPost> getAllBlogPosts() {
        return blogPostService.findAll();
    }

    //2
    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost body) {
        return blogPostService.saveBlogPost(body);
    }

    //3

    @GetMapping("/{blogpostId}")
    private BlogPost getBlogPostById(@PathVariable int blogpostId) {
        return blogPostService.findById(blogpostId);
    }

    //4
    @PutMapping("/{blogpostId}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable int blogpostId, @RequestBody BlogPost body) {
        return blogPostService.findByIdAndUpdate(blogpostId, body);
    }


    //5
    @DeleteMapping("{blogpostId}")
    private void findBlogPostByIdAndDelete(@PathVariable int blogpostId) {
        blogPostService.findByIdAndDelete(blogpostId);
    }
}
