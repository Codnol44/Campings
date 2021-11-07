package com.example.Campings.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.example.Campings.FileUploadUtil;
import com.example.Campings.bo.Camping;
import com.example.Campings.bo.Login;
import com.example.Campings.dal.CampingRepository;
import com.example.Campings.service.CampingService;
import com.example.Campings.service.LoginService;

@Controller
@Scope("singleton")
public class CampingController {
	
	//Lien avec la couche service
	private CampingService campingService;
	
	@Autowired
	public CampingController(CampingService campingService) {
		this.campingService = campingService;
	}
	
	@Autowired
    private CampingRepository campingRepo;
	
	@Autowired
    private LoginService userService;
    
    @GetMapping({"", "/login", "logout"})
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {
     Login oauthUser = userService.login(user.getUsername(), user.getPassword());
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
    	 return "redirect:/accueil";
     } else {
    	 return "redirect:/login";}
     }
    
    //Deconnexion
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
	
	@GetMapping("/accueil")
	public String accueil() {
		return "accueil";
	}
	
	@GetMapping("/liste")
	public String afficherListe(Model model) {
		model.addAttribute("liste", campingService.getCampings());
		return "liste";
	}
	
	@GetMapping("camping")
	public String afficherForm(Model model) {
		model.addAttribute("camping", new Camping());
		return "camping";
	}
	
    @PostMapping("/camping")
    public RedirectView saveUser(@ModelAttribute("camping") Camping camping, @RequestParam("image") MultipartFile multipartFile) throws IOException {
    	campingService.ajouterCamping(camping);
    	
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        camping.setPhoto(fileName);
         
        Camping savedCamping = campingRepo.save(camping);
 
        String uploadDir = "bp/" + savedCamping.getIdC();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/liste", true);
    }
	
	@GetMapping("/del")
	public String supprCamping(Model model, @RequestParam Long idC) {
		campingService.deleteCamping(idC);
		return "redirect:/liste";
	}

}


























