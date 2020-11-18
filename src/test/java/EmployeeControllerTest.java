import com.google.gson.Gson;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mmy.springboot.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mmy.springboot.EmployeeController.EMPLOYEES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getEmployees() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/employees?name=&distance=" + Integer.MAX_VALUE).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(EMPLOYEES)));
    }

    @Test
    public void getEmployee() throws Exception {
        val id = 1;
        mvc.perform(MockMvcRequestBuilders.get("/employee/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(EMPLOYEES.stream()
                        .filter(employee -> employee.getId() == id)
                        .findFirst()
                        .orElse(null))));
    }

    @Test
    public void getEmployeeById() throws Exception {
        val id = 2;
        mvc.perform(MockMvcRequestBuilders.get("/employee?id=" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(EMPLOYEES.stream()
                        .filter(employee -> employee.getId() == id)
                        .findFirst()
                        .orElse(null))));
    }

    @Test
    public void getEmployeeByName() throws Exception {
        val id = 2;
        mvc.perform(MockMvcRequestBuilders.get("/employee?id=" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(EMPLOYEES.stream()
                        .filter(employee -> employee.getId() == id)
                        .findFirst()
                        .orElse(null))));
    }
}
