package com.swedbank.studentapp.school;

import com.swedbank.studentapp.school.model.Building;
import com.swedbank.studentapp.school.model.ClassRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @GetMapping("/buildings")
    public List<Building> allBuildings() {return service.allBuildings();}

    @GetMapping("/buildings/{buildingId}/rooms")
    public List<ClassRoom> getBuildingRooms(@PathVariable final int buildingId){
        return service.getBuildingRooms(buildingId);
    }

    @GetMapping("/buildings/{buildingId}")
    public Building getBuilding(@PathVariable final int buildingId) {
        return service.getBuildingById(buildingId);
    }


    @PutMapping("/buildings/{buildingId}/rooms/{roomId}")
    public ClassRoom addClassRoom(@RequestBody ClassRoom room, @PathVariable int buildingId, @PathVariable long roomId){
        return service.addClassRoom(room, buildingId, roomId);
    }
}
