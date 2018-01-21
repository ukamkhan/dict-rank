package com.android.dictionary.dictrank;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictionaryController {

    private DictionaryService dictionaryService;

    @Autowired
    DictionaryController(DictionaryService dictionaryService){
        this.dictionaryService = dictionaryService;
    }

    @RequestMapping(value = "/dictionaries", method = RequestMethod.GET)
    public DictionaryList getDictionariesAboveRating(@RequestParam(value="rating") String rating) {
       return new DictionaryList(dictionaryService.findDictionaryByRating(new Double(rating).doubleValue()));
    }

}
