package com.example.www_week6.implement;

import com.example.www_week6.models.Post;
import com.example.www_week6.repository.PostRepo;
import com.example.www_week6.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostImple  implements PostService {
    @Autowired
    private PostRepo repo;
    @Override
    public Post save(Post u) {
        return repo.save(u);
    }

    @Override
    public List<Post> getAll() {
        return repo.findAll();
    }

    @Override
    public Page<Post> findPage(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return repo.findAll(pageable);
    }


}
