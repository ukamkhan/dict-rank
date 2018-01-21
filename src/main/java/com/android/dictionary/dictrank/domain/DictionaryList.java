package com.android.dictionary.dictrank.domain;

import java.util.List;

public class DictionaryList {

    private List<Dictionary> dictionaries;

    public DictionaryList(List<Dictionary> dictionaries){
        this.dictionaries = dictionaries;
    }

    public List<Dictionary> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(List<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }
}
