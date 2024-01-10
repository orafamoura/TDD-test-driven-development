package model;

import org.springframework.stereotype.Component;

@Component
public class Commission {
    public Double calcular(Double valueSale){
        return (valueSale > 1000.0) ? valueSale * 0.15 : valueSale * 0.10;
    }
}
