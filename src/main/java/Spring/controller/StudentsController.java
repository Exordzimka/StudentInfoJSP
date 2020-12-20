package Spring.controller;

import Models.Groups;
import Models.Students;
import Repository.GroupsRepository;
import Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/students")
public class StudentsController
{
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private GroupsRepository groupsRepository;

    @GetMapping
    public String students(Model model) {
        List<Students> students = studentsRepository.findAll();
        List<Groups> groups = groupsRepository.findAll();
        model.addAttribute("groups", groups);
        model.addAttribute("students",students);
        return "students/index";
    }

    @PostMapping(path="/add")
    public String add(@RequestParam String name, @RequestParam String secondName, @RequestParam String lastName,
                      @RequestParam long groupId, Model model )
    {
        Optional<Groups> group = groupsRepository.findById(groupId);
        Students students = new Students(name, secondName, lastName, group.get());
        studentsRepository.save(students);
        return "redirect:/students";
    }
}
