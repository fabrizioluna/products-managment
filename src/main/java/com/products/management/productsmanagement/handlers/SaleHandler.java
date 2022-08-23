package com.products.management.productsmanagement.handlers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.products.management.productsmanagement.entity.Invoice;
import com.products.management.productsmanagement.entity.Order;
import com.products.management.productsmanagement.entity.PayMethod;
import com.products.management.productsmanagement.entity.Product;
import com.products.management.productsmanagement.handlers.RestError.CustomError;
import com.products.management.productsmanagement.handlers.RestError.HandlerError;
import com.products.management.productsmanagement.services.InvoiceService;
import com.products.management.productsmanagement.services.OrderService;
import com.products.management.productsmanagement.services.ProductService;

@Component
public class SaleHandler {

    // Services we'll use
    private static ProductService productService;
    private static InvoiceService invoiceService;
    private static OrderService orderService;

    @Autowired
    private ProductService tproductService;

    @Autowired
    private InvoiceService tinvoiceService;

    @Autowired
    private OrderService torderService;

    @PostConstruct
    public void init() {
        SaleHandler.productService = tproductService;
        SaleHandler.invoiceService = tinvoiceService;
        SaleHandler.orderService = torderService;
    }

    public static Object registerSale(SalesHandler sale) {
        if (sale.getProducts().isEmpty())
            throw new HandlerError(new CustomError(400, "Something went wrong!",
                    "Please make sure the products list is not empty."));
        Boolean prodListResult = productListAssessment(sale.getProducts());
        ArrayList<Order> orders = new ArrayList<Order>();

        if (!prodListResult)
            throw new HandlerError(new CustomError(400, "Something went wrong!",
                    "One of the products does not exist."));

        // Genrate log invoice
        Invoice invoice = generateInvoice(sale.getPayMethod());
        // And then all orders
        for (Products order : sale.getProducts()) {
            orders.add(registerOrders(invoice, order.getProduct(), order.getPieces()));
        }
        return orders;
    }

    public static Order registerOrders(Invoice invoice, Long productId, Integer pieces) {
        Product product = productService.get(productId);
        Integer productPieces = product.getPieces();

        if (!(productPieces >= pieces))
            throw new HandlerError(new CustomError(400, "Something went wrong!",
                    "One of the products don't have those parts in stock to sell."));
        Order order = new Order();
        order.setInvoice(invoice);
        order.setOuts(pieces);
        order.setTimestamp(LocalTime.now());
        order.setProduct(product);

        // Product update
        product.setPieces(productPieces - pieces);
        updateProduct(product);

        return generateOrder(order);
    }

    public static Boolean productListAssessment(ArrayList<Products> prodList) {
        for (Products prod : prodList) {
            Boolean product_exist = productHasExist(prod.getProduct());
            // If the product not find it
            if (!product_exist)
                return product_exist;
        }
        return true;
    }

    public static Boolean productHasExist(Long id) {
        // Single method to check products
        Optional<Product> product = productService.existProduct(id);
        if (product.isPresent())
            return true;
        return false;
    }

    public static Order generateOrder(Order order) {
        return orderService.save(order);
    }

    public static Invoice generateInvoice(PayMethod paymethod) {
        return invoiceService.save(paymethod);
    }

    public static Product updateProduct(Product product) {
        return productService.save(product);
    }

}
