package process;

import dao.RequestDao;
import entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class Processor {
    /*
     *   Здесь описывается бизнес-логика, взаимодествие наружнего слоя и слоя, отвечающего за персистентность.
     *
     */
    @Autowired
    RequestDao dao;

    public void createNewRequest(Request request) throws Exception {

        List<Request> existsReqs = dao.getAllRequests();

        Date dt  = new Date();
        Request flag = existsReqs.stream()
                  .filter((Request e) -> e.getStartDate().before(request.getEndDate()) && e.getEndDate().after(request.getStartDate())
                           && dt.before(request.getStartDate()))
                  .findAny().orElse(null);

        if (flag == null) {
            dao.createRequest(request.getId(),request.getCustomer(), request.getStartDate(), request.getEndDate());
        } else {
            throw new Exception("Bad date borders");
        }

    }

    public List<Request> getRequestsByCustomer(String customer) {
        return dao.getRequestByCustomer(customer);
    }

    public List<Request> getAllRequests() {
        return dao.getAllRequests() ;
    }

    public void updateStatus (Request request) {
        dao.updateRequestStatus(request.getId(), request.getStatus());
    }

    public void deleteByCustomer(String customer){
        dao.deleteRequestByCustomer(customer);
    }
}
