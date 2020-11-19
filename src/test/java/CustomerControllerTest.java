import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import com.google.gson.Gson;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mmy.Application;
import org.mmy.dto.CustomerDto;
import org.mmy.persistence.CustomerRepository;
import org.mmy.services.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    public static final long ID = 1;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void getCustomer() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/customer/1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json(new Gson().toJson(customerRepository.findById(1L))));
        mvc.perform(MockMvcRequestBuilders.get("/customer/" + ID)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    val customer = new Gson().fromJson(result.getResponse().getContentAsString(), CustomerDto.class);
                    val dbCustomer = customerMapper.toDto(customerRepository.findById(ID).orElse(null));
                    if (!customer.equals(dbCustomer)) {
                        fail("getCustomer - fail");
                    }
                });
    }

    @Test
    void getCustomersByName() throws Exception {
        val sortParam = "lastName";
        mvc.perform(MockMvcRequestBuilders.get("/customers-by?name=p&sort=" + sortParam)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    val responseCustomers = Lists.newArrayList(new Gson().fromJson(result.getResponse().getContentAsString(), CustomerDto[].class));
                    val dbCustomers = customerRepository.findCustomersBy("p", Sort.by(sortParam)).stream()
                            .map(customerMapper::toDto)
                            .collect(toList());
                    if (!dbCustomers.equals(responseCustomers)) {
                        fail("getCustomersByName - fail");
                    }
                });
    }

    @Test
    void getCustomers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    val responseCustomers = Lists.newArrayList(new Gson().fromJson(result.getResponse().getContentAsString(), CustomerDto[].class));
                    val dbCustomers = Streams.stream(customerRepository.findAll())
                            .map(customerMapper::toDto)
                            .collect(toList());
                    if (!dbCustomers.equals(responseCustomers)) {
                        fail("getCustomersByName - fail");
                    }
                });
    }
}
