package com.webspoon.assignment.endpoint;

import com.webspoon.assignment.dto.SnippetDto;
import com.webspoon.assignment.dto.SnippetResponseDto;
import com.webspoon.assignment.services.SnippetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("snippets/recipe")
public class Snippet {
    @Autowired
    SnippetServices snippetServices;

    HashMap<Snippet, UUID> map = new HashMap<>();

    @PostMapping("")
    public ResponseEntity<SnippetResponseDto> createSnippet(@RequestBody SnippetDto snippetDto){
        ResponseEntity<SnippetResponseDto> responseEntity = new ResponseEntity();


    }

}
