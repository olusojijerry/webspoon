package com.webspoon.assignment.endpoint;

import com.webspoon.assignment.dto.LikesDto;
import com.webspoon.assignment.dto.SnippetDto;
import com.webspoon.assignment.dto.SnippetResponseDto;
import com.webspoon.assignment.exception.ApiException;
import com.webspoon.assignment.services.SnippetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("snippets/recipe")
public class SnippetApi {
    @Autowired
    SnippetServices snippetServices;

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
