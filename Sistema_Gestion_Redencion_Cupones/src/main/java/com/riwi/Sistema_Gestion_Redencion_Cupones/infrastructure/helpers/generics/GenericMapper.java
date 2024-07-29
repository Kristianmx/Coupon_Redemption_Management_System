package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics;

import java.util.List;

public interface GenericMapper<Request, Response, Entity> {
    Entity toEntity(Request request);

    Response toResponse(Entity entity);

    List<Response> toListResponse(List<Entity> entityList);
}

