package com.example.coupon.dto;

public record ApiResponse<T>(boolean success,
                             T data,
                             String message){
}
