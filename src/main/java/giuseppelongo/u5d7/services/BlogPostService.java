package giuseppelongo.u5d7.services;

import giuseppelongo.u5d7.entities.BlogPost;
import giuseppelongo.u5d7.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogPostList;
    }

    public BlogPost saveBlogPost(BlogPost body) {
        Random rndm = new Random();
        body.setId((rndm.nextInt(1, 200)));
        this.blogPostList.add(body);
        return body;
    }

    public BlogPost findById(int blogpostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogpostId) found = blogPost;

        }
        if (found == null) throw new NotFoundException(blogpostId);
        return found;

    }

    public BlogPost findByIdAndUpdate(int blogpostId, BlogPost updatedBlogPost) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogpostId) {
                found = blogPost;
                found.setCategory(updatedBlogPost.getCategory());
                found.setTitle(updatedBlogPost.getTitle());
                found.setCover(updatedBlogPost.getCover());
                found.setContent(updatedBlogPost.getContent());
                found.setTimeToRead(updatedBlogPost.getTimeToRead());

            }
        }
        if (found == null) throw new NotFoundException(blogpostId);
        return found;

    }

    public void findByIdAndDelete(int blogpostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogpostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogpostId);
        this.blogPostList.remove(found);
    }
}
