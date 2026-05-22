package com.lab.resources;
import com.lab.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    // Наша "база даних" у пам'яті сервера
    private final List<Product> products = new ArrayList<>();

    // 1. Отримати всі товари
    @GET
    public List<Product> getProducts() {
        return products;
    }

    // 2. Отримати конкретний товар за ID (ТЕ, ЩО МИ ДОДАЛИ)
    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Response.ok(product).build(); // Повертаємо 200 OK і товар
            }
        }
        // Якщо товару з таким ID немає — повертаємо красиву помилку 404
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"error\":\"Товар не знайдено\"}")
                .build();
    }

    // 3. Додати новий товар
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        products.add(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }
}