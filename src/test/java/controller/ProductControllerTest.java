package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class ProductControllerTest {
    //MockMvc
    //Mockito
    //Mock

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

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
        Mockito.when(this.productService.FindAll()).thenReturn(products);

        //Act
        this.mockMvc.perform(requestBuilder)

        //Assert
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deve_retornar_o_produto_por_id() throws Exception{
        //Arrange
        Product product = new Product();
        product.setId(2L);
        product.setName("Martelo");
        product.setQuantity(10);

        Optional<Product> optProduct = Optional.of(product);

        var requestBuilder = MockMvcRequestBuilders.get("/api/products/2");

        Mockito.when(this.productService.FindById(2L)).thenReturn(optProduct);

        //Act
        this.mockMvc.perform(requestBuilder)
        //Assert
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Martelo"));
    }

    @Test
    public void deve_adicionar_um_produto() throws Exception{
        //Arrange
        //criando o product
        Product product = new Product();
        product.setName("Martelo");
        product.setQuantity(10);

        //convertendo o product para json
        String json = new ObjectMapper().writeValueAsString(product);

        //criando a request do tipo post
        var requestBuilder = MockMvcRequestBuilders.post("/api/products")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        //adicionando o id ao product
        product.setId(1l);
        Mockito.when(this.productService.addProduct(product)).thenReturn(product);

        //Act
        this.mockMvc.perform(requestBuilder)
                //Assert
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


}
