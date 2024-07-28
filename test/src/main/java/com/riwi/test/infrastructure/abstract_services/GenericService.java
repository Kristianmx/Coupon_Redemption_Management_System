package com.riwi.test.infrastructure.abstract_services;

public interface GenericService<Request , Response, ID> {
    Response create(Request request);
    Response get(ID id);
    Response update(ID id, Request request);
    void delete(ID id);
}
