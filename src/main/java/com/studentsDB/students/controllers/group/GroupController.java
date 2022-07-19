package com.studentsDB.students.controllers.group;

import com.studentsDB.students.models.Groupu;
import com.studentsDB.students.service.GroupService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/rest")
public class GroupController {
    final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping("/groups/{id}")
    public String findGroupByID(@PathVariable(value = "id") Model model, Long id) {
        model.addAttribute("group", service.get(id));
        return "groups";
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<Groupu> deleteGroup(@PathVariable(value = "id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            if (id == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping("/groups/{id}")
    public @ResponseBody ResponseEntity<Groupu> updatePlayer(@PathVariable(name = "id") Long id,
                                                            @RequestBody Groupu newGroup) {
        service.update(service.get(id), newGroup);
        return new ResponseEntity<>(newGroup, HttpStatus.OK);
    }

    @PostMapping("/groups")
    public ResponseEntity<Groupu> createGroup(@RequestBody Groupu group) {
        try {
            service.save(group);
            return new ResponseEntity<>(group, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/groups")
    public String getGroupList(@NotNull Model model) {
        List<Groupu> groups = service.getAll();
        model.addAttribute("groups", groups);
        return "groups";
    }

}
