package com.android.dictionary.dictrank;

import com.android.dictionary.dictrank.domain.DictionaryList;
import com.android.dictionary.dictrank.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new DictionaryList(dictionaryService.getDictionaryGreaterThanRating(new Double(rating).doubleValue()));
    }

    @RequestMapping(value = "/language", method = RequestMethod.POST)
    public ResponseEntity<Language> addLanguage(@RequestParam(value="name") String languageName) {
        Language result = dictionaryService.addLanguage(languageName);
        return (result != null)? new ResponseEntity<>(result, HttpStatus.CREATED): new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
