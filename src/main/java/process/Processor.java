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

    public void createNewRequest(String customer, Date startDate, Date endDate){
        Request flag = new Request();

        List<Request> existsReqs = dao.getAllRequests();
        flag = existsReqs.stream().filter(
                 (Request e) -> e.getStartDate().before(endDate) && e.getEndDate().after(startDate))
                 .findAny().orElse(null);

        if (flag == null) {
            dao.createRequest(customer, startDate, endDate);
        }

    }
}
