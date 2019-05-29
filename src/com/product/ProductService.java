package com.product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public abstract boolean addProduct(List<Object> params);
    public List<Map<String,Object>> listProduct(String proname , int start, int end);
    public int getItemCount(String proname);
    public boolean delProduct(String[] ids);
    public Map<String, Object> viewProduct(String proid);
}
