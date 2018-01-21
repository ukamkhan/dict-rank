package com.android.dictionary.dictrank;

import com.android.dictionary.dictrank.domain.Dictionary;
import com.android.dictionary.dictrank.domain.Language;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FakeDictionaryRepository {

    private List<Dictionary> dictionaryList;
    private List<Language> languages;
    private final AtomicLong counterDictionary = new AtomicLong();
    private final AtomicLong counterLanguage = new AtomicLong();

    public FakeDictionaryRepository(){}

    private long getNextDictionaryId(){
        return counterDictionary.incrementAndGet();
    }

    private long getNextLanguageId(){
        return counterLanguage.incrementAndGet();
    }

    @PostConstruct
    public void initialize(){
        initLanguages();
        initDictionaries();
    }

    private void initDictionaries() {
        dictionaryList = new ArrayList<Dictionary>();
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "AlQamoos ul Jadeed Urdu Arabic", "applogy", 4.8,
                "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Arabic Urdu Dictionary", "Alif Innovative Solution",
                4.7, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Arbi Seekhen – Arbi Urdu Bol Chal", "Injeer Apps",
                4.4, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "AlQamoos ul Jadeed Arabic Urdu", "Islamicappz",
                4.1, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Al Munjid Complete Arabic-Urdu", "naveedapps",
                4.3, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "اردو-فارسی دیکشنری", "Glosbe",
                4.3, "free", "Persian", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Persian (Farsi) Urdu dict", "dict.land",
                3.8, "free", "Persian", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Farsi Urdu Bol Chal", "Salsabeel",
                4.4, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(getNextDictionaryId(), "Arbi Seekhen – Arbi Urdu Bol Chal", "Injeer Apps",
                4.4, "free", "Arabic", "Urdu"));
    }

    private void initLanguages() {
        languages = new ArrayList<>();
        languages.add(new Language(getNextLanguageId(), "Arabic"));
        languages.add(new Language(getNextLanguageId(), "Urdu"));
        languages.add(new Language(getNextLanguageId(), "Persian"));
    }

    public List<Dictionary> findDictionaryGreaterThanRating(double rating){
        List<Dictionary> result = new ArrayList<>();
        for( Dictionary dict : dictionaryList){
            if(dict.getRating() > rating){
                result.add(dict);
            }
        }
        return result;
    }

    public Language save(String language){
        Language newLanguage = new Language(getNextLanguageId(), language);
        languages.add(newLanguage);
        return newLanguage;
    }

    public List<Language> getLanguages(){
        return languages;
    }


}
