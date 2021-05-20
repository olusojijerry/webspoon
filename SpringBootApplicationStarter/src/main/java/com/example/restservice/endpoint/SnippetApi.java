package com.example.restservice.endpoint;

import com.example.restservice.dto.LikesDto;
import com.example.restservice.dto.SnippetDto;
import com.example.restservice.dto.SnippetResponseDto;
import com.example.restservice.exception.ApiException;
import com.example.restservice.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("snippets/recipe")
public class SnippetApi {
    @Autowired
    SnippetService snippetServices;

    @PostMapping("")
    public ResponseEntity<SnippetResponseDto> createSnippet(@RequestBody SnippetDto snippetDto) throws Exception {
        if(ObjectUtils.isEmpty(snippetDto)){
            throw new ApiException("Cannot upload empty snippet");
        }
        return new ResponseEntity<>(snippetServices.createSnippet(snippetDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SnippetResponseDto> getSnippetById(@PathVariable(name = "id") String id) throws Exception {
        return new ResponseEntity<>(snippetServices.getSnippetObj(id), HttpStatus.OK);
    }

    @PostMapping("/like")
    public ResponseEntity<SnippetResponseDto> likeSnippet(@RequestBody LikesDto likesDto) {
        if(ObjectUtils.isEmpty(likesDto)){
            throw new ApiException("Cannot upload empty snippet");
        }
        return new ResponseEntity<>(snippetServices.likeService(likesDto), HttpStatus.OK);
    }
}
