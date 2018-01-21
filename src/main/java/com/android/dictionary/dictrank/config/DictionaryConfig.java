package com.android.dictionary.dictrank.config;

import com.android.dictionary.dictrank.DictionaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictionaryConfig {

    @Bean
    public DictionaryService dictionaryService(){
        return new DictionaryService();
    }

}
