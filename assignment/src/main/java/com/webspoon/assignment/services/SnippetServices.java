package com.webspoon.assignment.services;

import com.webspoon.assignment.domain.Snippet;
import com.webspoon.assignment.dto.LikesDto;
import com.webspoon.assignment.dto.SnippetDto;
import com.webspoon.assignment.dto.SnippetResponseDto;
import com.webspoon.assignment.exception.ApiException;
import com.webspoon.assignment.utils.Constants;
import com.webspoon.assignment.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SnippetServices {
    Map<String, Snippet> map = new HashMap<>();

    public SnippetResponseDto createSnippet(SnippetDto snippetDto) throws Exception {
        SnippetResponseDto responseDto = new SnippetResponseDto();

        if (ObjectUtils.isEmpty(snippetDto.getSnippet())){
            throw new Exception("Snippet cannot be empty");
        }

        if (ObjectUtils.isEmpty(snippetDto.getName())){
            throw new Exception("Name cannot be empty");
        }

        if (ObjectUtils.isEmpty(snippetDto.getExpiresIn())){
            throw new Exception("Expiry Date cannot be empty");
        }

        Snippet snippet = mapperSnippet(snippetDto);

        map.put(snippet.getId(), snippet);

        return mapperSnippetResponse(snippet);
    }

    public Snippet mapperSnippet(SnippetDto snippetDto){
        Snippet snippet = new Snippet();

        UUID uuid = UUID.randomUUID();

        snippet.setCreatedDt(new Date());
        snippet.setExpiresIn(snippetDto.getExpiresIn());
        snippet.setId(uuid.toString());
        snippet.setName(snippetDto.getName());
        snippet.setSnippet(snippetDto.getSnippet());

        return snippet;
    }

    public SnippetResponseDto mapperSnippetResponse(Snippet snippet){
        SnippetResponseDto snippetResponseDto = new SnippetResponseDto();

        UUID uuid = UUID.randomUUID();

        snippetResponseDto.setUrl(Constants.BASE_URL.concat("/"+snippet.getId()));
        snippetResponseDto.setExpiresat(snippet.getExpiresIn());
        snippetResponseDto.setName(snippet.getName());
        snippetResponseDto.setSnippet(snippet.getSnippet());

        return snippetResponseDto;
    }

    public SnippetResponseDto getSnippetObj(String id) throws Exception {
        if(!map.containsKey(id)){
            throw new ApiException("Cannot find element");
        }

        Snippet snippet = new Snippet();

        for (Map.Entry<String, Snippet> pair : map.entrySet()){
            if (pair.getKey().equals(id)) {
                snippet = pair.getValue();
                break;
            }
        }

        Date presentDateTime = new Date();

        Date endDate = Utils.addSecondsToJavaUtilDate(snippet.getExpiresIn(), Constants.SECONDS_REQUIRED);

        if (endDate.compareTo(presentDateTime) < 0){
            throw new ApiException("Time expired cannot find element");
        }

        Boolean removed = map.remove(id, snippet);

        if(removed){
            snippet.setExpiresIn(endDate);

            map.put(snippet.getId(), snippet);
        }

        return mapperSnippetResponse(snippet);
    }

    public SnippetResponseDto likeService(LikesDto likesDto){
        if(!map.containsValue(likesDto.getId())){
            throw new ApiException("Cannot find element");
        }

        Snippet snippet = new Snippet();

        for (Map.Entry<String, Snippet> pair : map.entrySet()){
            if (pair.getKey().equals(likesDto.getId())) {
                snippet = pair.getValue();
                break;
            }
        }

        Integer likes = snippet.getLikes();

        likes++;

        Boolean removed = map.remove(snippet.getId(), snippet);

        if(removed){
            snippet.setLikes(likes);

            map.put(snippet.getId(), snippet);
        }

        return mapperSnippetResponse(snippet);
    }
}
