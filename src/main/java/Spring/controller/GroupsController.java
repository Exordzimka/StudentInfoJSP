package Spring.controller;

import Models.Groups;
import Repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path="/groups")
public class GroupsController
{
    @Autowired
    private GroupsRepository groupsRepository;

    @GetMapping
    public String groups(Model model) {
        List<Groups> groups = groupsRepository.findAll();
        model.addAttribute("groups",groups);
        return "groups/index";
    }

    @PostMapping(path="/add")
    public String add(@RequestParam String title, @RequestParam String curatorFamily, @RequestParam String titleDirection, Model model )
    {
        Groups group = new Groups(title,curatorFamily,titleDirection);
        groupsRepository.save(group);
        return "redirect:/groups";
    }
}
