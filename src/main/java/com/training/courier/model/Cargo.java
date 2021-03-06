package com.training.courier.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cargo parameters object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {


    /**
     * Weight
     */
    private Float weight;

    /**
     * Length
     */
    private Float length;

    /**
     * Width
     */
    private Float width;

    /**
     * Height
     */
    private Float height;
}
