package org.launchcode.controllers;


import org.launchcode.models.data.PreferenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("post")
public class PreferenceController {
    @Autowired
    private PreferenceDao preferenceDao;
}
