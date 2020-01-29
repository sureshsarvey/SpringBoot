package com.example.demo.service;

import com.example.demo.vo.Ingradinet;

public interface IngradinetService
{
    public void saveIngradinet(Ingradinet ing);
    
    public Ingradinet findById(Integer id);
}
