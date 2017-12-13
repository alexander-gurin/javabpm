
import entity.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import process.Processor;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=App.class)
    public class ControllerTest {

        @Autowired
        private MockMvc mvc;

        @MockBean
        private Processor processor;

        @Test
        public void giveAllRequest() throws Exception {

            Request request = new Request(1L, "testCustomer", new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2018"),
                    new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2018"),0);
           List<Request> allRequests = new ArrayList<>();
           allRequests.add(request);

           given(processor.getAllRequests()).willReturn(allRequests);

           mvc.perform(get("/allrequests")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customer", is(request.getCustomer())));
        }

    }

