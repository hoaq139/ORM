package com.example.ormassignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class OrderManagerController {
    private final OrderManagerService orderManagerService;
    private final CustomerRepository customerRepository;
    private final OrderManagerRepository orderManagerRepository;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final CustomerService customerService;


    @GetMapping("/order")
    public String getAllOrder(Model model) {
        List<Order> orderList = orderManagerService.getAll();
        model.addAttribute("orderList", orderList);
        return "OrderManage";
    }

    @GetMapping("/customer")
    public String getAllCustomer(Model model) {
        List<Customer> customerList = orderManagerService.getAllCustomer();
        model.addAttribute("customerList", customerList);
        return "CustomerList";
    }

    @PostMapping("/addcustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", Customer.builder().build());
        return "AddCustomer";
    }

    @GetMapping("/addorder")
    public String getOrder(Model model, @RequestParam("id") int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            Order order = new Order();
            order.setCustomer(customerOptional.get());
            model.addAttribute("order", order);
            return "CreateOrder";

        } else {

        }

        return "CreateOrder";
    }

    @PostMapping("/addorder")
    public String addOrder(@ModelAttribute Order order) {
        //Customer customer = orderManagerService.findID(id);
        order.getCustomer().setOrderList(null);
        orderManagerRepository.save(order);
        return "redirect:/order";
    }
    @GetMapping("/products/byCategory")
    public String findProductsByCategory(@RequestParam int categoryId, Model model) {
        Categories category = categoryService.findById(categoryId);
        if (category != null) {
            List<Products> products = productService.findProductByCategory(category);
            model.addAttribute("products", products);
            return "Products";
        }
        return "categoryNotFound"; // Handle category not found
    }
    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Categories> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "Category";
    }
    @GetMapping("/product")
    public String getProduct(Model model){
        List<Products> productsList = productService.getAll();
        model.addAttribute("productsList", productsList);
        return "ProductInfo";
    }
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "CustomerOrder";
    }
    @GetMapping("/orders/byCustomerId")
    public String findOrdersByCustomerId(@RequestParam int customerId, Model model) {
        Customer customer = customerService.findById(customerId);
        List<Order> orders = orderManagerService.findOrdersByCustomer(customer);
        model.addAttribute("orders", orders);
        return "Order";
    }
//    @GetMapping("/createorder")
//    public String getOrder(Model model){
//        List<Order> orderList = orderManagerService.getAll();
//        model.addAttribute("getOrder",orderList);
//        return "CreateOrder";
//    }
}
