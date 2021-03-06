package com.android.dictionary.dictrank;

import com.android.dictionary.dictrank.domain.Dictionary;
import com.android.dictionary.dictrank.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictionaryService {

    private FakeDictionaryRepository dictionaryRepository;

    @Autowired
    public DictionaryService(FakeDictionaryRepository dictionaryRepository){
        this.dictionaryRepository = dictionaryRepository;
    }

    public List<Dictionary> getDictionaryGreaterThanRating(double rating) {
        return dictionaryRepository.findDictionaryGreaterThanRating(rating);
    }

    public Language addLanguage(String languageName){
        List<Language> languages = dictionaryRepository.getLanguages();
        boolean exists = false;
        for(Language language: languages) {
            if (language.getName().equalsIgnoreCase(languageName)) {
                exists = true;
                break;
            }
        }
        if(!exists){
            return dictionaryRepository.save(languageName);
        }
        return null;
    }

    public Language getUrduLanguage(){
        List<Language> languages = dictionaryRepository.getLanguages();
        for (Language language: languages){
            if(language.getName().equals("Urdu")){
                return language;
            }
        }
        return null;
    }

    public List<Language> getAllLanguages(){
        return dictionaryRepository.getLanguages();
    }

}
