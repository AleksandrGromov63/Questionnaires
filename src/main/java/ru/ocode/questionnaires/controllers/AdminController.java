package ru.ocode.questionnaires.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.ocode.questionnaires.model.Issue;
import ru.ocode.questionnaires.model.Questionnaire;
import ru.ocode.questionnaires.model.User;
import ru.ocode.questionnaires.service.QuestionnairesService;
import ru.ocode.questionnaires.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private QuestionnairesService questionnairesService;
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allQuestionnaires", questionnairesService.getAllQuestionnaire());
        return "adminPage";
    }

    @GetMapping("/admin/questionnaires")
    public String questionnaires(Model model) {
        model.addAttribute("allQuestionnaires", questionnairesService.getAllQuestionnaire());
        return "ankets";
    }

    @DeleteMapping("/admin/questionnaires/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        questionnairesService.deleteQuestionnaire(id);
        return "redirect:/admin/questionnaires";
    }

    @GetMapping("/admin/questionnaires/{id}")
    public String select(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("questionnaire", questionnairesService.getById(id));
        return "take-the-survey";
    }

    @GetMapping("/admin/constructor")
    public String create(Model model) {
        model.addAttribute("questionnaire", new Questionnaire());
        return "constructor";
    }


    @PostMapping(value = "/admin/constructor", /*consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public String createQuestionnaire(@RequestParam("questionnaireName") String questionnaireName,
                                      @RequestBody MultiValueMap<String, String> mapWrapper,
                                      Model model) {
      /*  if (bindingResult.hasErrors()) {
            return "redirect:/admin";
        }*/

        questionnairesService.saveQuestionnaire(questionnaireName, mapWrapper);
        // model.addAttribute("issuesList", questionnaire.getIssues());
        return "redirect:/admin";
    }

   /* @PutMapping("/admin/questionnaires")
    public String createOrEditQuestionnaire(@ModelAttribute("questionnaireForm") @Valid Questionnaire questionnaireForm,
                                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/questionnaires";
        }
        questionnairesService.saveQuestionnaire(questionnaireForm);
        return "redirect:/admin/questionnaires";
    }*/

    @GetMapping("/admin/allusers")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @Getter
    @Setter
    @NoArgsConstructor
    class MapWrapper {
        private MultiValueMap<String, String> questions;
    }


}










