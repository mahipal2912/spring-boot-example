package smahi.com;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServimple implements CustomerService {

    @Autowired
    private CustomerRepository customrepo;

    @Autowired
    private EntityManager entityManager;

    public CustomerServimple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public String upsert(Customer customer) {
        customrepo.save(customer);
        return "success";
    }

    @Override
    public Customer getById(Long cid) {
        Optional<Customer> findById = customrepo.findById(cid);
        return findById.orElse(null);
    }
        @Override
        public List<Customer> getAllCustomers() {
            return customrepo.findAll();
        }

        @Override
        public String deleteById(Long cid) {
            if (customrepo.existsById(cid)) {
                customrepo.deleteById(cid);
                return "delete success";
            } else {
                return "no record found";
            }
        }
    @Override
    public   void deleteAllCustomers() {
         customrepo.deleteAll();
    }

    }

