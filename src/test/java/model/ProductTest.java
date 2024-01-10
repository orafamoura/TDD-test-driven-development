package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    public void deve_calcular_valor_produto(){

        Product product = new Product();
        product.setQuantity(10);
        product.setDiscount(10.0);
        product.setValueAdd(0.0);
        product.setValue(10.0);

        Double expectedOutcome = 90.0;

        Double result = product.calculateTotalValue();

        Assertions.assertEquals(expectedOutcome, result);
    }


}
