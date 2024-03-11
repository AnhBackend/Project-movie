package com.example.movie.service;

import com.example.movie.DTO.RevenueReportDTO;
import com.example.movie.repo.BillRepo;
import com.example.movie.repo.CinemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillSer {
    @Autowired
    BillRepo billRepo;
    @Autowired
    CinemaRepo cinemaRepo;
    public List<RevenueReportDTO> getRevenueReportByCinemaAndDateRange(int cinemaId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Object[]> result = billRepo.findTotalRevenueByCinemaAndDateRange(cinemaId, startDate, endDate);

        List<RevenueReportDTO> revenueReportDTOS = new ArrayList<>();
       for (Object[] row:result){
           String cinemaName = (String) row[0];
           Double totalRevenue = (Double) row[1];

           RevenueReportDTO reportDTO = new RevenueReportDTO();
           reportDTO.setCinemaName(cinemaName);
           reportDTO.setTotalRevenue(totalRevenue != null ? totalRevenue : 0.0);
           revenueReportDTOS.add(reportDTO);
       }
       return revenueReportDTOS;
    }
}
