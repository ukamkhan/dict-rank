package com.android.dictionary.dictrank;
import com.android.dictionary.dictrank.domain.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class DictionaryServiceTest {

    FakeDictionaryRepository dictionaryRepository = mock(FakeDictionaryRepository.class);

    DictionaryService dictionaryService = spy(new DictionaryService(dictionaryRepository));

    Language toAdd = spy(new Language(5, "French"));

    @BeforeClass
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLanguages_NoUrdu_NullReturned(){
        when(dictionaryRepository.getLanguages()).thenReturn(Collections.singletonList(new Language(34,"Bahsa")));
        Language result = dictionaryService.getUrduLanguage();
        Assert.assertNull(result);
    }

    @Test
    public void getLanguages_WithUrdu_UrduLanguageReturned(){
        when(dictionaryRepository.getLanguages()).thenReturn(languagesWithUrdu());
        Language result = dictionaryService.getUrduLanguage();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), "Urdu");
    }

    @Test
    public void addLanguage_doesNotExist_AddedSuccessFully(){
        when(dictionaryRepository.save("French")).thenReturn(toAdd);
        when(dictionaryRepository.getLanguages()).thenReturn(Collections.singletonList(new Language(34,"Chinese")));

        Language result = dictionaryService.addLanguage("French");
        Assert.assertNotNull(result);
    }

    @Test
    public void addLanguage_alreadyExists_AddNotSuccessful(){
        when(dictionaryRepository.getLanguages()).thenReturn(Collections.singletonList(new Language(11,"Japanese")));
        Language result = dictionaryService.addLanguage("Japanese");
        Assert.assertNull(result);
    }

    private List<Language> languagesWithUrdu(){
        List testLanguages = new ArrayList<Language>();
        testLanguages.add(new Language(31,"Urdu"));
        testLanguages.add(new Language(34,"Bahsa"));
        return  testLanguages;
    }

    private List<Language> languagesWithoutUrdu(){
        List testLanguages = new ArrayList<Language>();
        testLanguages.add(new Language(34,"Bahsa"));
        return  testLanguages;
    }
}
