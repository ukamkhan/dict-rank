package com.android.dictionary.dictrank;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DictionaryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dictionaries_getByRating_ResponseOk() throws Exception {

        this.mockMvc.perform(get("/dictionaries").param("rating", "4.7"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(status().isOk());
    }

    @Test
    public void dictionaries_getByRating_nonEmptyResult() throws Exception {

        this.mockMvc.perform(get("/dictionaries").param("rating", "4.5"))
                .andExpect(jsonPath("$.dictionaries").exists())
                .andExpect(jsonPath("$.dictionaries", hasSize(2)));
    }
}
