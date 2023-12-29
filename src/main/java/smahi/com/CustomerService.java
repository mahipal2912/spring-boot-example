package smahi.com;

import java.util.List;

public interface CustomerService {

     String upsert(Customer customer);
     Customer getById(Long cid);
     List<Customer> getAllCustomers();
     String deleteById(Long cid);

    void deleteAllCustomers();



}
