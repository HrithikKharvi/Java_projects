package com.example.components.systemStates;

import com.example.components.produts.Product;

public interface SystemState {
    void insertMode() throws Exception;
    void insertCoin(double amount) throws Exception;
    void dialMode() throws Exception;
    void dialCode(int code) throws Exception;
    void cancel() throws Exception;
    void finalizeCode(int code)throws Exception;
    Product dispenseProduct(int code) throws Exception;
    void refund()throws Exception;
}
