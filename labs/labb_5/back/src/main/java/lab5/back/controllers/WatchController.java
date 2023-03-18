package lab5.back.controllers;

import lab5.back.entity.Watch;
import lab5.back.services.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WatchController {
    @Autowired
    private WatchService service;

    @GetMapping("/")
    public String HomePage(Model model){
        List<Watch>listWatches = service.listAll();
        model.addAttribute("listWatches", listWatches);

        return "index";
    }


    @GetMapping("/toadd")
    public String AddForm(Model model){
        Watch watch = new Watch();
        model.addAttribute("watch", watch);

        return "added_watch";
    }
    @PostMapping("/toadd")
    public String saveWatch(@ModelAttribute("watch") Watch watch) {
        service.save(watch);

        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("updated_watch");
        Watch watch = service.get(id);
        mav.addObject("watch", watch);

        return mav;
    }


    @GetMapping("/delete/{id}")
    public String DeleteWatch(@PathVariable(name = "id") int id){
        service.delete(id);

        return "redirect:/";
    }
}
