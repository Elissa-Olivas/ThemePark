package com.detroitlabs.ThemePark.controller;

import com.detroitlabs.ThemePark.data.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("/")
    public String displayHome() {
        return "home";
    }

    @RequestMapping("/contact")
    public String displayContact(ModelMap modelMap) {
        modelMap.put("companyInfo", companyRepository.getCompanyInfo());
        return "contact";
    }

    @RequestMapping("/mygisney")
    public String displayMyGisneyland() {
        return "mygisney";
    }

}
