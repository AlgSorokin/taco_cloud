package com.elster.tacos.api;

import com.elster.tacos.data.OrderRepository;
import com.elster.tacos.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {

        /*Thymeleaf offers convenient access to the Errors object via the fields property and
        with its th:errors attribute. For example, to display validation errors on the credit
        card number field, you can add a <span> element that uses these error references to
        the order form template, as follows.*/
        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);

        /*Once the order is saved, you don’t need it hanging around in a session anymore.
                In fact, if you don’t clean it out, the order remains in session, including its associated
        tacos, and the next order will start with whatever tacos the old order contained.
        Therefore, the processOrder() method asks for a SessionStatus parameter and
        calls its setComplete() method to reset the session*/
        sessionStatus.setComplete();

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
