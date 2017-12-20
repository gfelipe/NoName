package br.uff.service;

import br.uff.model.Schedule;
import br.uff.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public Schedule findScheduleById(Long id){
        return scheduleRepository.findOne(id);
    }

    public List<Schedule> findSchedulesByProject(Long id){
        return scheduleRepository.findAllByProject(id);
    }

    public List<Schedule> getAllSchedules(){
        List<Schedule> schedules = new ArrayList<>();
        scheduleRepository.findAll().forEach(schedules::add);
        return schedules;

    }
}
