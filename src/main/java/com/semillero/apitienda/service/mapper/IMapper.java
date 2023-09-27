package com.semillero.apitienda.service.mapper;

public interface IMapper<I, O> {
    public O map(I in);
}
