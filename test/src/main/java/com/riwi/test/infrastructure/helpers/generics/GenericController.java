package com.riwi.test.infrastructure.helpers.generics;

import org.springframework.http.ResponseEntity;

public interface GenericController<Request, Response, ID> {
    ResponseEntity<Response> create(Request request);

    ResponseEntity<Response> read(ID id);

    ResponseEntity<Response> update(Request request, ID id);

    ResponseEntity<Void> delete(ID id);
}
