package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
@SpringBootConfiguration
public class CommissionTest { // teste unitario, testa classe/componente

    @TestConfiguration
    static class CommissionConfiguration{
        @Bean
        public Commission commission(){
            return new Commission();
        }
    }
    @Autowired
    Commission commission;

    @Test
    public void deve_calcular_100_reais_de_comissao_para_venda_de_1000_com_10_por_cento(){ //snake case, com _ e sem maiusculo
        //Arrange = preparacao
        Double valueSale = 1000.0;
        Double valueCommission = 100.0;

        //Act = Acao
        Double calculatedCommission = commission.calcular(valueSale);

        //Assert = Confirmacao
        Assertions.assertEquals(valueCommission,calculatedCommission);
    }
    @Test
    public void deve_calcular_300_reais_de_comissao_para_venda_de_2000_com_15_por_cento(){ //snake case, com _ e sem maiusculo
        //Arrange = preparacao
        Double valueSale = 2000.0;
        Double valueCommission = 300.0;

        //Act = Acao
        Double calculatedCommission = commission.calcular(valueSale);

        //Assert = Confirmacao
        Assertions.assertEquals(valueCommission,calculatedCommission);
    }



}
