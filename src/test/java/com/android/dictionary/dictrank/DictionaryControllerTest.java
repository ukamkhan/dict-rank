package com.android.dictionary.dictrank;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DictionaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dictionaries_getByRating_ResponseOk() throws Exception {
        this.mockMvc.perform(get("/dictionaries").param("rating", "4.9"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dictionaries").exists())
                .andExpect(jsonPath("$.dictionaries", hasSize(0)));
    }

    @Test
    public void dictionaries_getByRating_nonEmptyResult() throws Exception {
        this.mockMvc.perform(get("/dictionaries").param("rating", "4.5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dictionaries").exists())
                .andExpect(jsonPath("$.dictionaries", hasSize(2)));
    }

    @Test
    public void language_addNonExisitng_addSuccessful() throws Exception {
        this.mockMvc.perform(post("/language").param("name", "French"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists());
    }

    @Test
    public void language_addExisitng_addNotSuccessful() throws Exception {
        this.mockMvc.perform(post("/language").param("name", "Arabic"))
                .andExpect(status().isBadRequest());
    }
}
