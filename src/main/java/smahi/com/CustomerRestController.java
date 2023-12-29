package smahi.com;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerRestController {


    private final CustomerService customserv;

    public CustomerRestController(CustomerService customserv) {
        this.customserv = customserv;
    }

    @PostMapping("/c1/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        String status = customserv.upsert(customer);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/c1/customer/{cid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid) {
        Customer customer = customserv.getById(Long.valueOf(cid));
        return new ResponseEntity<>(customer, HttpStatus.OK);


    }

    @GetMapping("/c1/customers")

    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customserv.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);

    }

    @PutMapping("/c1/customer")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        String status = customserv.upsert(customer);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @DeleteMapping("/c1/customer/{cid}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer cid) {
        String status = customserv.deleteById(Long.valueOf(cid));
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @DeleteMapping("/c1/customers")

    public String deleteAllCustomers() {
         customserv.deleteAllCustomers();
        return "all entity deleted successfully";


    }

    }