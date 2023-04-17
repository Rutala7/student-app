package com.swedbank.studentapp.school;

import com.swedbank.studentapp.school.exception.BuildingNotFoundException;
import com.swedbank.studentapp.school.exception.RoomsNotFoundException;
import com.swedbank.studentapp.school.model.Building;
import com.swedbank.studentapp.school.model.ClassRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final BuildingRepository buildingRepository;

    private final RoomsRepository roomRepository;

    public List<Building> allBuildings() {return buildingRepository.findAll();}

    public Building getBuildingById(Integer id) {
        return buildingRepository.findById(id)
                .orElseThrow(() -> new BuildingNotFoundException(id));
    }

    public List<ClassRoom> getBuildingRooms(int id){
        var building = buildingRepository.findById(id)
                .orElseThrow(() -> new RoomsNotFoundException(id));
        return building.getRoomSet();
    }

    public ClassRoom addClassRoom(ClassRoom newRoom, int buildingId, long roomId) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new BuildingNotFoundException(buildingId));
        return roomRepository.findById(roomId).map(room -> {
            room.setName(newRoom.getName());
            room.setCapacity(newRoom.getCapacity());
            room.setFloor(newRoom.getFloor());
            room.setBuilding(building);
            return roomRepository.save(room);
        }).orElseGet(() ->{newRoom.setId(roomId);
            newRoom.setBuilding(building);
            return roomRepository.save(newRoom);
        });
    }
}
