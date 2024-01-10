package controller;

import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ProductControllerTest {
    //MockMvc
    //Mockito
    //Mock

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach // antes de cada caso de teste o setup e executado
    public void setup() {
        //sera executado antes de qualquer caso de teste
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

    }

    @Test
    public void deve_retornar_status_200_OK_obter_todos_produtos() throws Exception{
        //Arrange
        List<Product> products = new ArrayList<Product>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/products");

        //Act
        this.mockMvc.perform(requestBuilder)

        //Assert
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
//oi


}
