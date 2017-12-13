package web;

import entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import process.Processor;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    Processor processor;

    @RequestMapping(value="/create", method= RequestMethod.POST, produces="application/json", consumes="application/json")
    public void createRequest(@RequestBody Request request) throws Exception {
        processor.createNewRequest(request);
    }

    @RequestMapping(value="/requests/{customer}",produces="application/json", method=RequestMethod.GET)
    public List<Request> getRequestsByCustomer(@PathVariable("customer") String customer)
    {
        return processor.getRequestsByCustomer(customer);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
    public void updateStatus(@RequestBody Request request)
    {
        processor.updateStatus(request);
    }

    @RequestMapping(value="/delete/{customer}",method = RequestMethod.DELETE, produces="application/json")
    public void deleteRequestsByCustomer(@PathVariable("customer") String customer)
    {
        processor.deleteByCustomer(customer);
    }
}
