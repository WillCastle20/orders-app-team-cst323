package edu.williamcastellanos.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.williamcastellanos.products.data.OrdersDataService;
import edu.williamcastellanos.products.models.OrdersModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersDataService ordersDataService;

    public OrdersController(OrdersDataService ordersDataService) {
        this.ordersDataService = ordersDataService;
    }

    @GetMapping("")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", ordersDataService.getAll());
        model.addAttribute("title", "All Orders");
        return "allOrders";
    }

    @GetMapping("/showOrder/{id}")
    public String showOneOrder(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", ordersDataService.getById(id));
        model.addAttribute("title", "One Order");
        return "showOrder";
    }

    // show edit form
    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", ordersDataService.getById(id));
        model.addAttribute("title", "Edit Order");
        return "editOrder";
    }

    // process edit form
    @PostMapping("/processEditOrder")
    public String updateOrder(OrdersModel orderModel, BindingResult br, Model model) {
        ordersDataService.update(orderModel);
        return "redirect:/orders";
    }

    // show new order form
    @GetMapping("/newOrder")
    public String newOrder(Model model) {
        model.addAttribute("order", new OrdersModel());
        model.addAttribute("title", "New Order");
        return "newOrder";
    }

    @GetMapping("/deleteOrder/{id}")
public String deleteOrder(@PathVariable("id") int id, Model model) {
    ordersDataService.deleteById(id);
    return "redirect:/orders";
}

@PostMapping("/processNewOrder")
public String processNewOrder(OrdersModel orderModel, BindingResult br, Model model) {
    ordersDataService.create(orderModel);
    return "redirect:/orders";
}
}