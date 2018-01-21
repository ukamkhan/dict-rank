package com.android.dictionary.dictrank.config;

import com.android.dictionary.dictrank.DictionaryService;
import com.android.dictionary.dictrank.FakeDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictionaryConfig {

    @Autowired
    private FakeDictionaryRepository dictionaryRepository;

    @Bean
    public DictionaryService dictionaryService(){
        return new DictionaryService(dictionaryRepository);
    }

}
