package com.android.dictionary.dictrank;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DictionaryService {

    private List<Dictionary> dictionaryList;

    @Autowired
    public DictionaryService(){
        dictionaryList = new ArrayList<Dictionary>();
        dictionaryList.add(new Dictionary(1, "AlQamoos ul Jadeed Urdu Arabic", "applogy", 4.8,
                            "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(2, "Arabic Urdu Dictionary", "Alif Innovative Solution",
                            4.8, "free", "Arabic", "Urdu"));
        dictionaryList.add(new Dictionary(2, "Arbi Seekhen – Arbi Urdu Bol Chal", "Injeer Apps",
                4.4, "free", "Arabic", "Urdu"));
    }

    public List<Dictionary> findDictionaryByRating(double rating){
        List<Dictionary> result = new ArrayList<Dictionary>();
        for( Dictionary dict : dictionaryList){
            if(dict.getRating() > rating){
                result.add(dict);
            }
        }
        return result;
    }
}
