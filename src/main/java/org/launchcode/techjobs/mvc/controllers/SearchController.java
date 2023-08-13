package org.launchcode.techjobs.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }
    @PostMapping(value = "results")
    public String displaySearchResults(Model model, String searchType, String searchTerm) {
        if (searchType.equals("all")) {
            model.addAttribute("jobs", ListController.columnChoices);
            model.addAttribute("title", "All Jobs");
        } else {
            model.addAttribute("jobs", ListController.columnChoices);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }
        return "search";
    }
    // TODO #3 - Create a handler to process a search request and render the updated search view.

}
