package dao;

import entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RequestDao implements Query {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createRequest(Long id, String customer, Date startDate, Date endDate){
        jdbcTemplate.update(CREATE_REQUEST, id, customer, startDate, endDate);
    }

    public List<Request> getRequestByCustomer(String customer){
        return jdbcTemplate.query(GET_REQUESTS_BY_CUSTOMER, (rs, rowNum) -> new Request(rs.getLong("id"),
                                                                                        rs.getString("name"),
                                                                                        rs.getDate("start_date"),
                                                                                        rs.getDate("end_date"),
                                                                                        rs.getInt("status")),
                customer);

    }

    public List<Request> getAllRequests(){
        return jdbcTemplate.query(GET_ALL_REQUESTS, (rs, rowNum) -> new Request(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getInt("status")));
    }

    public void updateRequestStatus(Long id, Integer status){
        jdbcTemplate.update(UPDATE_REQUEST_STATUS, status, id);
    }

    public void deleteRequestByCustomer(String customer){
        jdbcTemplate.update(DELETE_REQUESTS_BY_NAME, customer);
    }
}
