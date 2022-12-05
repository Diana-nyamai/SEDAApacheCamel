package com.Books.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvisionResponse {
    private int RetCode;
    private String RetDesc;
}
