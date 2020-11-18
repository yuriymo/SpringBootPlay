import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mmy.springboot.Application;
import org.mmy.springboot.Customer;
import org.mmy.springboot.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    public static final long ID = 8;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CustomerRepository customerRepository;

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
                    val responseCustomer = new Gson().fromJson(result.getResponse().getContentAsString(), Customer.class);
                    val customer = new Customer(ID, responseCustomer.getFirstName(), responseCustomer.getLastName());
                    val dbCustomer = customerRepository.findById(ID).orElse(null);
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
                    val responseCustomers = Lists.newArrayList(new Gson().fromJson(result.getResponse().getContentAsString(), Customer[].class));
                    val dbCustomers = customerRepository.findCustomersBy("p", Sort.by(sortParam));
                    if (!dbCustomers.equals(responseCustomers)) {
                        fail("getCustomersByName - fail");
                    }
                });
    }

    @Test
    void findCustomersBy() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/customer/search/findCustomersBy?name=p")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    val responseCustomers = new Gson().fromJson(result.getResponse().getContentAsString(), CustomerResponse.class).get_embedded().getCustomer();
                    val dbCustomers = customerRepository.findCustomersBy("P", Sort.by("lastName")).stream()
                            .map(customer -> new Customer(customer.getFirstName(), customer.getLastName()))
                            .collect(toList());
                    if (!dbCustomers.equals(responseCustomers)) {
                        fail("findCustomersBy - fail");
                    }
                });
    }
}

@Getter
class CustomerResponse {
    Embedded _embedded;
}

@Getter
class Embedded {
    List<Customer> customer;
}