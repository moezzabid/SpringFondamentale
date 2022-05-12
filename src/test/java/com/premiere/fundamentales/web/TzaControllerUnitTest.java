package com.premiere.fundamentales.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.ApplicationService;
import service.TicketService;

import java.awt.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TzaController.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TzaControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService ;

    @MockBean
    TicketService ticketService;

    @Test
    public void getAllApplications() throws Exception{
        mockMvc.perform(get("/tza/applicationsd"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(PageAttributes.MediaType.Application_JSON_UTF8))
                .andExpect(content().json("[]"));
        verify(applicationService,times(1)).listApplications();

    }

}
