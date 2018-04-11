package ru.bogdanium.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogdanium.bookstore.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{id}/{quantity}")
    public String process(@PathVariable Long id, @PathVariable int quantity) {
        orderService.processOrder(id, quantity);
        return "redirect:/books";
    }
}
